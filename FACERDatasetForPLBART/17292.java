    @Override
    public void onPlaybackStatusChanged(int state) {
        Log.d(TAG, "onPlaybackStatusChanged:called");
        Log.i(TAG, "onPlaybackStatusChanged:state="+Playback.states[state]);

        updatePlaybackState(null);
    }

