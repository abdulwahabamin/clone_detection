    private static void setSeekbarDuration(int duration) {
        mMPSeekBar.setMax(duration);
        mMPSeekBar.setProgress(PlayerConstants.mSongPlayback.getCurrentMediaPlayer().getCurrentPosition() / 1000);
        mMiniProgressBar.setMax(duration);
        mMiniProgressBar.setProgress(PlayerConstants.mSongPlayback.getCurrentMediaPlayer().getCurrentPosition() / 1000);
        mHandler.postDelayed(seekbarUpdateRunnable, 0);
    }

