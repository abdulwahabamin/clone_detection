    /**
     * Returns the current play list
     * @return An array of integers containing the IDs of the tracks in the play list
     */
    public int [] getQueue() {
        synchronized (this) {
            int len = mPlayListLen;
            int [] list = new int[len];
            for (int i = 0; i < len; i++) {
                list[i] = mPlayList[i];
            }
            return list;
        }
    }

