    /**
     * Starts a new readahead operation. Will resume if `path' equals
     * the currently open file
     *
     * @param path The path to read ahead
     */
    public void setSource(String path) {
        pause(); // cancell all in-flight rpc's
        mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_PATH, path), 1000);
    }

