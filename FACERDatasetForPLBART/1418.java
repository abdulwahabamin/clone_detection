        @Override
        public void onConnectionError(String error){
            synchronized (mLock){
                if(mStreamThread!=null)
                    mStreamThread.end();

                mProgressBar.dismiss();
                mProgressBar.cancel();

                showStatus(BluetoothChatService.STATE_NONE);
                showInfo("[!] Error : " + error);

            }
        }

