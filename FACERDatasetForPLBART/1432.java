        @Override
        public void onDataStream(byte[] data){
            synchronized (mLock){
                if( mLastLength != data.length ) {
                    showInfo("Received " + data.length + " bytes via BLE!");
                    mLastLength = data.length;
                    mHandler.post(new Runnable() {
                      @Override
                      public void run() {
                          mProgressBar.show();
                      }
                    });
                }

                long now = System.currentTimeMillis();
                if( mStartingTime == 0 ){
                    mStartingTime = now;
                }
                if( mStartingTime + 1000 <= now ){
                    showInfo( mBytesPerSec + " B/s");
                    mBytesPerSec = mStartingTime = 0;
                }

                //showIncomingMessage("Msg length: " + data.length);
                mBytesPerSec += data.length;
                mProgressBarStatus += data.length;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressBar.setProgress(mProgressBarStatus);
                    }
                });

            }
        }

