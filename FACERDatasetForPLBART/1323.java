        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            super.onServicesDiscovered(gatt, status);
            Log.d(TAG, "onServicesDiscovered:");

            for (BluetoothGattService service : gatt.getServices()) {
                Log.d(TAG, "Service: "+service.getUuid());
                if (BLEChatProfile.SERVICE_UUID.equals(service.getUuid())) {
                    gatt.readCharacteristic(service.getCharacteristic(BLEChatProfile.CHARACTERISTIC_VERSION_UUID));
                    gatt.readCharacteristic(service.getCharacteristic(BLEChatProfile.CHARACTERISTIC_DESC_UUID));
                    gatt.setCharacteristicNotification(service.getCharacteristic(BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID), true);
                    gatt.setCharacteristicNotification(service.getCharacteristic(BLEChatProfile.CHARACTERISTIC_RFCOMM_TRANSFER_UUID), true);
                    gatt.setCharacteristicNotification(service.getCharacteristic(BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID), true);
                }
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mBleChatEvents.onConnect();
                }
            });
        }

