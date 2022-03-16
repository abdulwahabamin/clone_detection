        @Override
        public void onDisconnect(){
            synchronized (mLock) {
                Message msg = mHandler.obtainMessage(Constants.MESSAGE_TOAST);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.TOAST, new String("[!] Disconnected"));
                msg.setData(bundle);
                mHandler.sendMessage(msg);

                showStatus(BluetoothChatService.STATE_NONE);
                if(mProgressBar!=null){
                    mProgressBar.dismiss();
                    mProgressBar.hide();
                }

            }
        }

