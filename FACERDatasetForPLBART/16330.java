    /**
     * 跳到输入的进度
     */
    public void movePlay(int progress) {
        mMediaPlayer.seekTo(progress);
        currentTime = progress;
    }

