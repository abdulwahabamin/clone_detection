    /**
     * Sends a block of random data
     */
    public synchronized void sendStream(){
        notifyChatListeners(NotifyChatAction.NOTIFY_CHAT_ACTION_INFO, "Not tested yet!");
        byte[] randomBytes = new byte[512];
        (new Random()).nextBytes(randomBytes);

        for (BluetoothDevice device : mConnectedDevices) {
            BluetoothGattCharacteristic transferCharacteristic = mGattServer.getService(BLEChatProfile.SERVICE_UUID)
                    .getCharacteristic(BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID);
            transferCharacteristic.setValue(randomBytes);
            mGattServer.notifyCharacteristicChanged(device, transferCharacteristic, false);
        }
    }

