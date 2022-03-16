    public synchronized void seek(int posn) {
        Log.d(TAG, "seek(" + posn + ") entry.");
        if (currentTrackPlayer != null)
            currentTrackPlayer.seekTo(posn);
        else {
            deferredPosition = posn;
            Log.d(TAG, "seek() deferredPosition set to " + posn);
        }
    }

