    private void stop() {
        mPlaybackHander.removeMessages(DUCK);
        mPlaybackHander.removeMessages(FADEUP);
        mPlaybackHander.removeMessages(FADEDOWN);
        mPlaybackHander.removeMessages(CROSSFADE);
        for (MyMediaPlayer player : mPlayers) player.stop();
        resetMetadata();
    }

