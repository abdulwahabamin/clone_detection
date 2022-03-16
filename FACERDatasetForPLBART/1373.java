    /**
     * Returns an array of bytes representing the value of the Description characteristic
     * @return
     */
    private byte[] getCharacteristicDescValue() {
        synchronized (mLock) {
            return BLEChatProfile.getDescription().getBytes();
        }
    }

