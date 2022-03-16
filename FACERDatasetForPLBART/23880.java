    public synchronized void setTrack(int trackIndex) {
        Log.d(TAG, "setTrack(" + trackIndex + ") entry.");
        if ((trackIndex >= 0) && (trackIndex < songs.size())) {
            resetToInitialState();
            deferredGo = false;
            playingIndexInfo = null;
            onDeckIndexInfo = new IndexInfo(trackIndex);
            onDeckTrackPlayer = prepareTrack(trackIndex);
        } else {
            Log.d(TAG, "setTrack(" + trackIndex + ") index out of bounds, max=" + songs.size());
        }
    }

