    public synchronized int getPosition() {
        //Log.d(TAG,"getPosition() entry.");
        if (currentTrackPlayer != null)
            return currentTrackPlayer.getCurrentPosition();
        Log.d(TAG, "getPosition() not playing?");
        return 0;
    }

