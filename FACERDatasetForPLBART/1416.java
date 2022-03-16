        @Override
        public void onConnect(){
            synchronized (mLock){
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage("/name Z3C");
                        showConnectedName(mConnectedDeviceName);
                        showStatus(BluetoothChatService.STATE_CONNECTED);
                    }
                }, 2000);
            }
        }

