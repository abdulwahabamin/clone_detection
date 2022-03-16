        @Override
        public void onDataStream(byte[] data){
            synchronized (mLock){
                if( mLastLength != data.length ) {
                    showInfo("Received " + data.length + " bytes via BLE!");
                    mLastLength = data.length;
                }
                //showIncomingMessage(new String(data));
            }
        }

