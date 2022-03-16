        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);
            Log.d(TAG, "onConnectionStateChange "
                    +BLEChatProfile.getStatusDescription(status)+" "
                    +BLEChatProfile.getStateDescription(newState));

            if(status == BluetoothGatt.GATT_SUCCESS) {
                if (newState == BluetoothProfile.STATE_CONNECTED) {
                    gatt.discoverServices();
                } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mBleChatEvents.onDisconnect();
                        }
                    });

                }
            }else{
                final int finalStatus = status;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onConnectionError("Connection state error! : Error = " + finalStatus);
                    }
                });

            }
        }

