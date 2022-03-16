    /**
     * This will send back a message with the Bluetooth interface address to the Central device who wanted to
     * initialize the RFCOMM transfer. The Central device will use this address in the scanning phase to uniquely
     * identify this devices so he can filter and connect to it.
     */
    private void sendTransferReady(){
        for (BluetoothDevice device : mConnectedDevices) {
            BluetoothGattCharacteristic transferCharacteristic = mGattServer.getService(BLEChatProfile.SERVICE_UUID)
                    .getCharacteristic(BLEChatProfile.CHARACTERISTIC_RFCOMM_TRANSFER_UUID);
            String macAddress = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "bluetooth_address");
            transferCharacteristic.setValue(macAddress);
            mGattServer.notifyCharacteristicChanged(device, transferCharacteristic, false);
        }
    }

