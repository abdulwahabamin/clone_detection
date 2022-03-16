    @Override
    public synchronized int removeTrack(long id) {
        int numremoved = 0;
        for (int i = 0; i < mPlayListLen; i++) {
            if (mPlayList[i] == id) {
                numremoved += removeTracksInternal(i, i);
                i--;
            }
        }
        if (numremoved > 0) {
            notifyChange(QUEUE_CHANGED);
        }
        return numremoved;
    }

