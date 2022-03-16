    /**
     * 暂�?�或开始播放歌曲
     */
    public void pausePlay() {
        if (mMediaPlayer.isPlaying()) {
            currentTime = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        } else {
            mMediaPlayer.start();
        }
    }

