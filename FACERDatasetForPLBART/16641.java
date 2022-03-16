    public void handlePauseRequest() {
        FireLog.d(TAG, "(++) handlePauseRequest: mState=" + playback.getState());
        if (playback.isPlaying()) {
            playback.pause();
            serviceCallback.onPlaybackStop();
        }
    }

