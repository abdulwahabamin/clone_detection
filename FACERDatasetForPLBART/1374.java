    public void send(String msg) {
        for (BluetoothDevice device : mConnectedDevices) {
            BluetoothGattCharacteristic msgCharacteristic = mGattServer.getService(BLEChatProfile.SERVICE_UUID)
                    .getCharacteristic(BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID);
            msgCharacteristic.setValue(msg);
            mGattServer.notifyCharacteristicChanged(device, msgCharacteristic, false);
        }
    }

