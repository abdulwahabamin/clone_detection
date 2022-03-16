    /**
     * Returns the current play list
     * 
     * @return An array of integers containing the IDs of the tracks in the play
     *         list
     */
    public long[] getQueue() {
        synchronized (this) {
            int len = mPlayListLen;
            long[] list = new long[len];
            for (int i = 0; i < len; i++) {
                list[i] = mPlayList[i];
            }
            return list;
        }
    }

