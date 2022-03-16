    /**
     * Method that send a signal to the current command.
     *
     * @param SIGNAL The signal to send
     * @return boolean If the signal was sent
     * @hide
     */
    private boolean sendSignalToCurrentCommand(SIGNAL signal) {
        synchronized (this.mSync) {
            // Check background console
            try {
                FileManagerApplication.getBackgroundConsole();
            } catch (Exception e) {
                Log.w(TAG, "There is not background console. Not allowed.", e); //$NON-NLS-1$
                return false;
            }

            if (this.mActiveCommand.getCommand() != null) {
                try {
                    boolean isCancellable = true;
                    if (this.mActiveCommand instanceof AsyncResultProgram) {
                        final AsyncResultProgram asyncCmd =
                                (AsyncResultProgram)this.mActiveCommand;
                        isCancellable = asyncCmd.isCancellable();
                    }

                    if (isCancellable) {
                        try {
                            //Get the PIDs in background
                            List<Integer> pids =
                                    CommandHelper.getProcessesIds(
                                            null,
                                            this.mShell.getPid(),
                                            FileManagerApplication.getBackgroundConsole());
                            for (Integer pid: pids) {
                                if (pid != null) {
                                    CommandHelper.sendSignal(
                                            null,
                                            pid.intValue(),
                                            signal,
                                            FileManagerApplication.getBackgroundConsole());
                                    try {
                                        //Wait for process to be signaled
                                        Thread.sleep(100L);
                                    } catch (Throwable ex) {
                                        /**NON BLOCK**/
                                    }
                                }
                            }
                            return true;
                        } finally {
                            // It's finished
                            this.mCancelled = true;
                            notifyProcessFinished();
                            this.mSync.notify();
                        }
                    }
                } catch (Throwable ex) {
                    Log.w(TAG,
                        String.format("Unable to send signal to current program: %s", //$NON-NLS-1$
                                this.mActiveCommand.getCommand()), ex);
                }
            }
        }
        return false;
    }

