    @Override
    public int getCurrentPosition() {
        if (isPlaying() || isPaused()) {
            return mMediaPlayer.getCurrentPosition();
        }
        return -1;
    }

