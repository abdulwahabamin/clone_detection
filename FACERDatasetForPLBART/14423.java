    /**
     * Seeks to the position specified.
     * 
     * @param pos The position to seek to, in milliseconds
     */
    public long seek(long pos) {
        if (mPlayer.isInitialized()) {
            if (pos < 0)
                pos = 0;
            if (pos > mPlayer.duration())
                pos = mPlayer.duration();
            return mPlayer.seek(pos);
        }
        return -1;
    }

