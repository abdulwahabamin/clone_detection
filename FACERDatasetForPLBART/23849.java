    private void updatePlayingStatus() {
        int drawable = R.drawable.ic_playback_start;
        if (isPlaying())
            drawable = R.drawable.ic_playback_pause;
        mPlayPauseButton.setImageResource(drawable);
    }

