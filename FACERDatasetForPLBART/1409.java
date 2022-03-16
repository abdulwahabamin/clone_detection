    private synchronized void sendMessageViaBLE(String message) {
        // Check that there's actually something to send
        if (message.length() > 0) {
            if(mBleMode == BLEMode.PERIPHERAL){
                BLEPeripheralHelper.getInstance().send(message);
            }else if(mBleMode == BLEMode.CENTRAL){
                BLECentralHelper.getInstance().send(message);
            }
            showOutgoingMessage(message);
            // Reset out string buffer to zero and clear the edit text field
            mOutStringBuffer.setLength(0);
            mOutEditText.setText(mOutStringBuffer);
        }
    }

