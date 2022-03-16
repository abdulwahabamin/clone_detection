    private void updatePlaybackState(PlaybackStateCompat state) {
        if (state == null) {
            return;
        }
        playbackState = state;

        switch (state.getState()) {
            case PlaybackStateCompat.STATE_PLAYING:
                progressBar.setVisibility(INVISIBLE);
                playPauseBtn.setVisibility(VISIBLE);
                playPauseBtn.setImageDrawable(pauseDrawable);
                scheduleSeekbarUpdate();
                break;
            case PlaybackStateCompat.STATE_PAUSED:
                progressBar.setVisibility(INVISIBLE);
                playPauseBtn.setVisibility(VISIBLE);
                playPauseBtn.setImageDrawable(playDrawable);
                stopSeekbarUpdate();
                break;
            case PlaybackStateCompat.STATE_NONE:
            case PlaybackStateCompat.STATE_STOPPED:
                progressBar.setVisibility(INVISIBLE);
                playPauseBtn.setVisibility(VISIBLE);
                playPauseBtn.setImageDrawable(playDrawable);
                stopSeekbarUpdate();
                break;
            case PlaybackStateCompat.STATE_BUFFERING:
                playPauseBtn.setVisibility(INVISIBLE);
                progressBar.setVisibility(VISIBLE);
                stopSeekbarUpdate();
                break;
            default:
                FireLog.d(TAG, "Unhandled state " + state.getState());
        }

        previousBtn.setVisibility((state.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS) == 0
                ? INVISIBLE : VISIBLE);
        previousBtn.setVisibility((state.getActions() & PlaybackStateCompat.ACTION_SKIP_TO_NEXT) == 0
                ? INVISIBLE : VISIBLE);
    }

