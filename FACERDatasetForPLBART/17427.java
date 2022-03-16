    @Override
    public synchronized void seekTo(int position) {
        Log.d(TAG, "seekTo():called");
        Log.i(TAG, "seekTo:state="+Playback.states[mState]);
        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "seekTo:player is preparing");
            return;
        }

        seekPlayerTo(position);
    }

