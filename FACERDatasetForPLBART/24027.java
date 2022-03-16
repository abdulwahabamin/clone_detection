    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void updateMediaSession(boolean isPlaying) {
        PlaybackState.Builder stateBuilder = new PlaybackState.Builder()
                .setActions(isPlaying ? PlaybackState.ACTION_PAUSE : PlaybackState.ACTION_PLAY);
        stateBuilder.setState(isPlaying ? PlaybackState.STATE_PLAYING : PlaybackState.STATE_PAUSED,
                mPlayers[mCurrentPlayer].currentPosition(), 1.0f);
        mSession.setPlaybackState(stateBuilder.build());
    }

