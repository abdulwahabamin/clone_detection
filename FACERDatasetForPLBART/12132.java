    /**
     * {@inheritDoc}
     */
    @Override
    public final void alloc() throws ConsoleAllocException {
        try {
            //Create command string
            List<String> cmd = new ArrayList<String>();
            cmd.add(this.mShell.getCommand());
            if (this.mShell.getArguments() != null && this.mShell.getArguments().length() > 0) {
                cmd.add(this.mShell.getArguments());
            }

            //Create the process
            Runtime rt = Runtime.getRuntime();
            this.mProc =
                    rt.exec(
                            cmd.toArray(new String[cmd.size()]),
                            this.mShell.getEnvironment(),
                            new File(FileHelper.ROOT_DIRECTORY).getCanonicalFile());
            synchronized (this.mSync) {
                this.mActive = true;
            }
            if (isTrace()) {
                Log.v(TAG,
                        String.format("Create console %s, command: %s, args: %s, env: %s",  //$NON-NLS-1$
                                this.mShell.getId(),
                                this.mShell.getCommand(),
                                this.mShell.getArguments(),
                                Arrays.toString(this.mShell.getEnvironment())));
            }

            //Allocate buffers
            this.mIn = this.mProc.getInputStream();
            this.mErr = this.mProc.getErrorStream();
            this.mOut = this.mProc.getOutputStream();
            if (this.mIn == null || this.mErr == null || this.mOut == null) {
                try {
                    dealloc();
                } catch (Throwable ex) {
                    /**NON BLOCK**/
                }
                throw new ConsoleAllocException("Console buffer allocation error."); //$NON-NLS-1$
            }

            //Starts a thread for extract output, and check timeout
            createStdInThread(this.mIn);
            createStdErrThread(this.mErr);

            //Wait for thread start
            Thread.sleep(50L);

            //Check if process its active
            checkIfProcessExits();
            synchronized (this.mSync) {
                if (!this.mActive) {
                    throw new ConsoleAllocException("Shell not started."); //$NON-NLS-1$
                }
            }

            // Retrieve the PID of the shell
            ProcessIdExecutable processIdCmd =
                    getExecutableFactory().
                        newCreator().createShellProcessIdExecutable();
            // Wait indefinitely if the console is allocating a su command. We need to
            // wait to user response to SuperUser or SuperSu prompt (or whatever it is)
            // The rest of sync operations will run with a timeout.
            execute(processIdCmd, this.isPrivileged());
            Integer pid = null;
            try {
                pid = processIdCmd.getResult().get(0);
            } catch (Exception e) {
                // Ignore
            }
            if (pid == null) {
                throw new ConsoleAllocException(
                        "can't retrieve the PID of the shell."); //$NON-NLS-1$
            }
            this.mShell.setPid(pid.intValue());

            //Retrieve identity
            IdentityExecutable identityCmd =
                    getExecutableFactory().newCreator().createIdentityExecutable();
            execute(identityCmd, null);
            this.mIdentity = identityCmd.getResult();
            // Identity command is required for root console detection,
            // but Groups command is not used for now. Also, this command is causing
            // problems on some implementations (maybe toolbox?) which don't
            // recognize the root AID and returns an error. Safely ignore on error.
            try {
                if (this.mIdentity.getGroups().size() == 0) {
                    //Try with groups
                    GroupsExecutable groupsCmd =
                            getExecutableFactory().newCreator().createGroupsExecutable();
                    execute(groupsCmd, null);
                    this.mIdentity.setGroups(groupsCmd.getResult());
                }
            } catch (Exception ex) {
                Log.w(TAG, "Groups command failed. Ignored.", ex); //$NON-NLS-1$
            }

        } catch (Exception ex) {
            try {
                dealloc();
            } catch (Throwable ex2) {
                /**NON BLOCK**/
            }
            throw new ConsoleAllocException("Console allocation error.", ex); //$NON-NLS-1$
        }

    }

