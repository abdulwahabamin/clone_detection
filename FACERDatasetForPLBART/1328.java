    public void send(byte[] data) {
        final BluetoothGattCharacteristic characteristic = mConnectedGatt
                .getService(BLEChatProfile.SERVICE_UUID)
                .getCharacteristic(BLEChatProfile.CHARACTERISTIC_MESSAGE_UUID);

        characteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        characteristic.setValue(data);
        if(!mConnectedGatt.writeCharacteristic(characteristic)){
            mBleChatEvents.onConnectionError("Couldn't send data!!");
        }
    }

