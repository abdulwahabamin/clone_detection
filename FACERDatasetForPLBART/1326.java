        @Override
        public void onMtuChanged (BluetoothGatt gatt,
                           int mtu,
                           int status){
            final int chatStatus = (status == BluetoothGatt.GATT_SUCCESS ? BLECentralChatEvents.MTU_CHANGE_SUCCEED : BLECentralChatEvents.MTU_CHANGE_FAILED);
            mMtu = mtu;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mBleChatEvents.onMtuChanged(chatStatus, mMtu);
                }
            });
        }

