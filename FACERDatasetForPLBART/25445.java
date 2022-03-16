    /**
     * Aborts all current in-flight RPCs, pausing the readahead operation
     */
    public void pause() {
        mHandler.removeMessages(MSG_SET_PATH);
        mHandler.removeMessages(MSG_READ_CHUNK);
    }

