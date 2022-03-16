        private void showProgressBar(){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.show();
                }
            });
        }

