    @Override
    public synchronized void pause() {
        mPlaybackHander.removeMessages(DUCK);
        mPlaybackHander.removeMessages(FADEUP);
        mPlaybackHander.removeMessages(FADEDOWN);
        mPlaybackHander.removeMessages(CROSSFADE);

        boolean wasPlaying = isPlaying();

        for (MyMediaPlayer player : mPlayers) {
            if (player.isPlaying()) player.pause();
        }
        gotoIdleState();

        if (wasPlaying) {
            notifyChange(PLAYSTATE_CHANGED);
        }

        mPausedByTransientLossOfFocus = false;
    }

