    public synchronized void playTrack(int trackIndex) {
        Log.d(TAG, "playTrack(" + trackIndex + ") entry.");
        if ((trackIndex >= 0) && (trackIndex < songs.size())) {
            setTrack(trackIndex);
            deferredGo = true;
        } else {
            Log.d(TAG, "playTrack(" + trackIndex + ") index out of bounds, max=" + songs.size());
        }
    }

