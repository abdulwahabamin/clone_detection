    /**
     * Method for execute a command in the operating system layer.
     *
     * @param executable The executable command to be executed
     * @param waitForSu Wait for su (do not used timeout)
     * @throws ConsoleAllocException If the console is not allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws CommandNotFoundException If the executable program was not found
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     */
    private synchronized void execute(final Executable executable, final boolean waitForSu)
            throws ConsoleAllocException, InsufficientPermissionsException,
            CommandNotFoundException, NoSuchFileOrDirectory,
            OperationTimeoutException, ExecutionException, ReadOnlyFilesystemException {

        //Is a program?
        if (!(executable instanceof Program)) {
            throw new CommandNotFoundException("executable not instanceof Program"); //$NON-NLS-1$
        }

        //Asynchronous or synchronous execution?
        final Program program = (Program)executable;
        if (executable instanceof AsyncResultExecutable) {
            Thread asyncThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Synchronous execution (but asynchronous running in a thread)
                    //This way syncExecute is locked until this thread ends
                    try {
                        //Synchronous execution (2 tries with 1 reallocation)
                        final ShellConsole shell = ShellConsole.this;
                        if (shell.syncExecute(program, true, false)) {
                            shell.syncExecute(program, false, false);
                        }
                    } catch (Exception ex) {
                        if (((AsyncResultExecutable)executable).getAsyncResultListener() != null) {
                            ((AsyncResultExecutable)executable).
                                getAsyncResultListener().onException(ex);
                        } else {
                            //Capture exception
                            Log.e(TAG, "Fail asynchronous execution", ex); //$NON-NLS-1$
                        }
                    }
                }
            });
            asyncThread.start();
        } else {
            //Synchronous execution (2 tries with 1 reallocation)
            program.setExitOnStdErrOutput(waitForSu);
            if (syncExecute(program, true, waitForSu) && !waitForSu) {
                syncExecute(program, false, false);
            }
        }
    }

