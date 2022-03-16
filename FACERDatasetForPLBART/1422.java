        @Override
        public void onStreamSent(int status){
            synchronized (mLock) {
                if (status == BLEChatEvents.SENT_SUCCEED) {
                    mStreamThread.nextMessage();
                } else {
                    mStreamThread.end();
                }
            }
        }

