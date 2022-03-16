        @Override
        public void onMtuChanged(int status, int newMtu){
            synchronized (mLock) {
                if (status == BLECentralChatEvents.MTU_CHANGE_SUCCEED) {
                    showInfo("MTU changed to " + newMtu);
                } else {
                    showInfo("Error changing MTU. Falling back to " +  newMtu + " ...");
                }
                // Once the MTU has been changed, we start the thread for the transfer rate test
                mStreamThread = new StreamThread();
                mStreamThread.start();
            }
        }

