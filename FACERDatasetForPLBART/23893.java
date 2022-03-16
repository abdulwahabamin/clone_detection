    public synchronized void playNext() {
        Log.d(TAG, "playNext() entry.");
        resetToInitialState();
        deferredGo = true;
        playingIndexInfo = null;
        if ((onDeckIndexInfo != null) && (songs != null) && (!songs.isEmpty()))
            onDeckTrackPlayer = prepareTrack(onDeckIndexInfo.getTrackIndex());
    }

