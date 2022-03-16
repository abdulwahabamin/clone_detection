        @Override
        public void onCharacteristicRead(BluetoothGatt gatt,
                                         final BluetoothGattCharacteristic characteristic,
                                         int status) {
            super.onCharacteristicRead(gatt, characteristic, status);
            if (BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID.equals(characteristic.getUuid())) {
                final String msg = characteristic.getStringValue(0);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onMessage(msg);
                    }
                });

                //Register for further updates as notifications
                gatt.setCharacteristicNotification(characteristic, true);
            }
            if (BLEChatProfile.CHARACTERISTIC_VERSION_UUID.equals(characteristic.getUuid())) {
                final String version = characteristic.getStringValue(0);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onVersion(version);
                    }
                });

                //Register for further updates as notifications
                gatt.setCharacteristicNotification(characteristic, true);
            }
            if (BLEChatProfile.CHARACTERISTIC_DESC_UUID.equals(characteristic.getUuid())) {
                final String description = characteristic.getStringValue(0);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mBleChatEvents.onDescription(description);
                    }
                });

                //Register for further updates as notifications
                gatt.setCharacteristicNotification(characteristic, true);
            }
        }

