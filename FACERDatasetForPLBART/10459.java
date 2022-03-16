        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncExitCode(int exitCode) {
            if (this.mRef != null) {
                this.mRef.onAsyncExitCode(exitCode);
            }

            // Now if that the process has finished check if the operation
            // requires to unmount the filesystem
            if (this.mUnmount && this.mConsole != null &&
                this.mMountPoint != null && this.mCtx != null) {
                // Run in background because the console is still executing
                // the command
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            MountExecutable unmountExecutable =
                                    UnmountAsyncResultListener.this.mConsole.
                                        getExecutableFactory().newCreator().
                                            createMountExecutable(
                                                    UnmountAsyncResultListener.this.mMountPoint,
                                                    false);
                            UnmountAsyncResultListener.this.mConsole.execute(
                                    unmountExecutable, mCtx);
                        } catch (Exception e) {
                            // Capture the exception but not show to the user
                            ExceptionUtil.translateException(
                                    UnmountAsyncResultListener.this.mCtx, e, true, false);
                        }
                    }
                };
                t.start();
            }
        }

