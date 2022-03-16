        @Override
        public void onCharacteristicWrite (BluetoothGatt gatt,
                                    BluetoothGattCharacteristic characteristic,
                                    int status){
            if (BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID.equals(characteristic.getUuid())){
                final int chatStatus = (status == BluetoothGatt.GATT_SUCCESS ? BLEChatEvents.SENT_SUCCEED : BLEChatEvents.SENT_FAILED);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onStreamSent(chatStatus);
                    }
                });
            }

        }

