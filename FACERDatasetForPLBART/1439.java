        private void updateProgressBar(final int increment){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.setProgress(increment);
                }
            });
        }

