    public synchronized int getTrackIndex() {
        if (playingIndexInfo != null)
            return playingIndexInfo.getTrackIndex();
        else
            return -1;
    }

