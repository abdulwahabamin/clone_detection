    @Override
    public void onServiceConnected(MediaPlayback s) {
        Log.i(TAG, "onServiceConnected");
        service = s;
        updateNowPlaying();
    }

