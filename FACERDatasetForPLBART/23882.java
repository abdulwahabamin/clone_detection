    public synchronized int getDuration() {
        //Log.d(TAG,"getDuration() entry.");
        if (currentTrackPlayer != null)
            return currentTrackPlayer.getDuration();
        Log.d(TAG, "getDuration() not playing?");
        return 0;
    }

