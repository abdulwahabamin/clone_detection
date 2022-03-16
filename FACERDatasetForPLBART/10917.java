        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncExitCode(int exitCode) {
            synchronized (this.mSync) {
                mReadDoneLocked = true;
                this.mSync.notify();
            }
        }

