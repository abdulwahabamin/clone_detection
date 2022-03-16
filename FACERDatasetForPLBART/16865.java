    private void updateProgress() {
        if (playbackState == null) {
            return;
        }
        long currentPosition = playbackState.getPosition();
        if (playbackState.getState() == PlaybackStateCompat.STATE_PLAYING) {
            long timeDelta = SystemClock.elapsedRealtime() -
                    playbackState.getLastPositionUpdateTime();
            currentPosition += (int) timeDelta * playbackState.getPlaybackSpeed();
        }
        seekBar.setProgress((int) currentPosition);
        circularSeekBar.setProgress((int) currentPosition);
    }

