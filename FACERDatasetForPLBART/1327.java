        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt,
                                            final BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);
            Log.i(TAG, "Notification of message characteristic changed on server.");
            if (BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID.equals(characteristic.getUuid())) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onMessage(characteristic.getStringValue(0));
                    }
                });
            } else if (BLEChatProfile.CHARACTERISTIC_RFCOMM_TRANSFER_UUID.equals(characteristic.getUuid())) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRfcommSocketAddress = characteristic.getStringValue(0);
                        connect2RfcommSocket();
                        //mBleChatEvents.onTransfer(characteristic.getStringValue(0));
                    }
                });
            } else if (BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID.equals(characteristic.getUuid())) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onInfo("BLE_TRANS Charac changed!!");
                    }
                });
            }
        }

