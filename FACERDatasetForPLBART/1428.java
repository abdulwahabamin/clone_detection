        @Override
        public void onConnectionError(String error) {
            synchronized (mLock){
                if(mProgressBar != null){
                    mProgressBar.dismiss();
                    mProgressBar.hide();
                }

                showInfo("[!] Error : " + error);
            }
        }

