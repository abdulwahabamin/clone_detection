        private void hideProgressBar(){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.dismiss();
                    mProgressBar.hide();
                }
            });
        }

