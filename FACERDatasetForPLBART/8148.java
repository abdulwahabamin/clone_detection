        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncExitCode(int exitCode) {
            synchronized (this.mSync) {
                this.mSync.notify();
            }
        }

