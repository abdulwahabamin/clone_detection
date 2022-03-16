    /**
     * Returns an array of bytes representing the value of the Version characteristic
     * @return
     */
    private byte[] getCharacteristicVersionValue() {
        synchronized (mLock) {
            return BLEChatProfile.getVersion().getBytes();
        }
    }

