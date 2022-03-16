    private synchronized void sendMessage(String message) {
        if(mBleMode != BLEMode.NONE)
            sendMessageViaBLE(message);
        else
            sendMessageViaClassicBT(message);
    }

