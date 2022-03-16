    /**
     * A heads-up to the adapter to indicate that new items might be added
     * Allows the adapter to setup a buffer to take in the new results and incorporate the new
     * items periodically
     */
    public void startStreaming() {
        mInStreamingMode = true;
        mHandler.postDelayed(mParseNewResults, STREAMING_MODE_REFRESH_DELAY);
    }

