    /**
     * Sends a MTU size block of data
     */
    public synchronized void sendData() {

        //byte[] data = getAlphabetDataBlock(mMtu);
        byte[] data = new byte[mMtu];

        final BluetoothGattCharacteristic characteristic = mConnectedGatt
                .getService(BLEChatProfile.SERVICE_UUID)
                .getCharacteristic(BLEChatProfile.CHARACTERISTIC_BLE_TRANSFER_UUID);

        characteristic.setValue(data);
        characteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        int iRetries = 0;
        while (!mConnectedGatt.writeCharacteristic(characteristic)) {
            try {
                if (iRetries > MAX_RETRIES) {
                    mBleChatEvents.onConnectionError("Couldn't send more data!!");
                    return;
                }
                iRetries++;
                Log.d(TAG, "Error sending data. Retrying... " + iRetries);
                // We are in StreamThread thread.... so we can sleep
                Thread.sleep(BLEChatProfile.SEND_INTERVAL);
            } catch (InterruptedException ex) {
                mBleChatEvents.onConnectionError("Interrupted while sleeping!!");
                return;
            }
        }
    }

