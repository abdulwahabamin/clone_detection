    /**
     * Method for execute a program command in the operating system layer in a synchronous way.
     *
     * @param program The program to execute
     * @param reallocate If the console must be reallocated on i/o error
     * @param waitForSu Wait for su (do not used timeout)
     * @return boolean If the console was reallocated
     * @throws ConsoleAllocException If the console is not allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @hide
     */
    synchronized boolean syncExecute(
            final Program program, boolean reallocate, boolean waitForSu)
            throws ConsoleAllocException, InsufficientPermissionsException,
            CommandNotFoundException, NoSuchFileOrDirectory,
            OperationTimeoutException, ExecutionException, ReadOnlyFilesystemException {

        try {
            //Check the console status before send command
            checkConsole();

            synchronized (this.mSync) {
                if (!this.mActive) {
                    throw new ConsoleAllocException("No console allocated"); //$NON-NLS-1$
                }
            }

            //Saves the active command reference
            this.mActiveCommand = program;
            final boolean async = program instanceof AsyncResultProgram;

            //Reset the buffers
            this.mStarted = false;
            this.mCancelled = false;
            this.mSbIn = new ByteArrayOutputStream();
            this.mSbErr = new ByteArrayOutputStream();

            //Random start/end identifiers
            String startId1 =
                    String.format("/#%d#/", Long.valueOf(this.mRandom.nextLong())); //$NON-NLS-1$
            String startId2 =
                    String.format("/#%d#/", Long.valueOf(this.mRandom.nextLong())); //$NON-NLS-1$
            String endId1 =
                    String.format("/#%d#/", Long.valueOf(this.mRandom.nextLong())); //$NON-NLS-1$
            String endId2 =
                    String.format("/#%d#/", Long.valueOf(this.mRandom.nextLong())); //$NON-NLS-1$

            //Create command string
            String cmd = program.getCommand();
            String args = program.getArguments();

            //Audit command
            if (isTrace()) {
                Log.v(TAG,
                        String.format("%s-%s, command: %s, args: %s",  //$NON-NLS-1$
                                this.mShell.getId(),
                                program.getId(),
                                cmd,
                                args));
            }

            //Is asynchronous program? Then set asynchronous
            program.setProgramListener(this);
            if (async) {
                ((AsyncResultProgram)program).setOnCancelListener(this);
                ((AsyncResultProgram)program).setOnEndListener(this);
            }

            //Send the command + a control code with exit code
            //The process has finished where control control code is present.
            //This control code is unique in every invocation and is secure random
            //generated (control code 1 + exit code + control code 2)
            try {
                boolean hasEndControl = (!(program instanceof AsyncResultProgram) ||
                                           (program instanceof AsyncResultProgram &&
                                            ((AsyncResultProgram)program).isExpectEnd()));
                mControlPattern.setNewPattern(startId1, startId2, endId1, endId2);

                String startCmd =
                        Command.getStartCodeCommandInfo(
                                FileManagerApplication.getInstance().getResources());
                startCmd = String.format(
                        startCmd, "'" + startId1 +//$NON-NLS-1$
                        "'", "'" + startId2 + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                String endCmd =
                        Command.getExitCodeCommandInfo(
                                FileManagerApplication.getInstance().getResources());
                endCmd = String.format(
                        endCmd, "'" + endId1 + //$NON-NLS-1$
                        "'", "'" + endId2 + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                StringBuilder sb = new StringBuilder()
                    .append(startCmd)
                    .append(" ")  //$NON-NLS-1$
                    .append(cmd)
                    .append(" ")  //$NON-NLS-1$
                    .append(args);
               if (hasEndControl) {
                   sb = sb.append(" ") //$NON-NLS-1$
                          .append(endCmd);
               }
               sb.append(FileHelper.NEWLINE);
               synchronized (this.mSync) {
                   this.mFinished = false;
                   this.mNewData = false;
                   this.mOut.write(sb.toString().getBytes());
               }
            } catch (InvalidCommandDefinitionException icdEx) {
                throw new CommandNotFoundException(
                        "ExitCodeCommandInfo not found", icdEx); //$NON-NLS-1$
            }

            //Now, wait for buffers to be filled
            synchronized (this.mSync) {
                if (!this.mFinished) {
                    if (waitForSu || program.isIndefinitelyWait()) {
                        this.mSync.wait();
                    } else {
                        final long start = System.currentTimeMillis();
                        while (true) {
                            this.mSync.wait(DEFAULT_TIMEOUT);
                            if (!this.mFinished) {
                                final long end = System.currentTimeMillis();
                                if (!program.isWaitOnNewDataReceipt() ||
                                    !this.mNewData ||
                                    (end - start >= MAX_OPERATION_TIMEOUT)) {
                                    throw new OperationTimeoutException(end - start, cmd);
                                }

                                // Still waiting for program ending
                                this.mNewData = false;
                                continue;
                            }
                            break;
                        }
                    }
                }
            }

            //End partial results?
            if (async) {
                synchronized (this.mPartialSync) {
                    ((AsyncResultProgram)program).onRequestEndParsePartialResult(this.mCancelled);
                }
            }

            //Retrieve exit code
            int exitCode = getExitCode(this.mSbIn, async);
            if (async) {
                synchronized (this.mPartialSync) {
                    ((AsyncResultProgram)program).onRequestExitCode(exitCode);
                }
            }
            if (isTrace()) {
                Log.v(TAG,
                        String.format("%s-%s, command: %s, exitCode: %s",  //$NON-NLS-1$
                                this.mShell.getId(),
                                program.getId(),
                                cmd,
                                String.valueOf(exitCode)));
            }

            //Check if invocation was successfully or not
            if (!program.isIgnoreShellStdErrCheck()) {
                //Wait for stderr buffer to be filled
                if (exitCode != 0) {
                    try {
                        Thread.sleep(100L);
                    } catch (Throwable ex) {/**NON BLOCK**/}
                }
                this.mShell.checkStdErr(this.mActiveCommand, exitCode, this.mSbErr.toString());
            }
            this.mShell.checkExitCode(exitCode);
            program.checkExitCode(exitCode);
            program.checkStdErr(exitCode, this.mSbErr.toString());

            //Parse the result? Only if not partial results
            if (program instanceof SyncResultProgram) {
                try {
                    ((SyncResultProgram)program).parse(
                            this.mSbIn.toString(), this.mSbErr.toString());
                } catch (ParseException pEx) {
                    throw new ExecutionException(
                            "SyncResultProgram parse failed", pEx); //$NON-NLS-1$
                }
            }

            //Invocation finished. Now program.getResult() has the result of
            //the operation, if any exists

        } catch (OperationTimeoutException otEx) {
            try {
                killCurrentCommand();
            } catch (Exception e) { /**NON BLOCK **/}
            throw otEx;

        } catch (IOException ioEx) {
            if (reallocate) {
                realloc();
                return true;
            }
            throw new ExecutionException("Console allocation error.", ioEx); //$NON-NLS-1$

        } catch (InterruptedException ioEx) {
            if (reallocate) {
                realloc();
                return true;
            }
            throw new ExecutionException("Console allocation error.", ioEx); //$NON-NLS-1$

        } finally {
            //Dereference the active command
            this.mActiveCommand = null;
        }

        //Operation complete
        return false;
    }

