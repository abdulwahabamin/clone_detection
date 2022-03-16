    private void setMediaSessionState(boolean isPlaying) {
        Log.d(TAG, "setMediaSessionState(" + isPlaying + ") entry.");
        if (isPlaying) {
            PlaybackState state = new PlaybackState.Builder()
                    .setActions(PlaybackState.ACTION_PAUSE |
                            PlaybackState.ACTION_SKIP_TO_NEXT |
                            PlaybackState.ACTION_SKIP_TO_PREVIOUS)
                    .setState(PlaybackState.STATE_PLAYING, PlaybackState.PLAYBACK_POSITION_UNKNOWN, 1)
                    .build();
            mediaSession.setPlaybackState(state);
        } else {
            PlaybackState state = new PlaybackState.Builder()
                    .setActions(PlaybackState.ACTION_PLAY)
                    .setState(PlaybackState.STATE_STOPPED, PlaybackState.PLAYBACK_POSITION_UNKNOWN, 1)
                    .build();
            mediaSession.setPlaybackState(state);
        }
    }

