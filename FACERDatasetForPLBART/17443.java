    private boolean setPlayerDataSource(String source) {
        Log.d(TAG, "setPlayerDataSource():called");
        Log.i(TAG, "setPlayerDataSource:state="+Playback.states[mState]);

        // if idle then only we can set source
        if (!isIdle()) {
            return false;
        }

        try {
            mMediaPlayer.setDataSource(source);
        } catch (IOException e) {
            Log.e(TAG, "setPlayerDataSource:exception", e);
            e.printStackTrace();
            return false;
        }

        mState = Playback.CUSTOM_PLAYBACK_STATE_STOPPED;
        return true;
    }

