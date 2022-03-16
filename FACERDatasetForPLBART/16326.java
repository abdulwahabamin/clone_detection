    /**
     * 根�?�歌曲存储路径播放歌曲
     */
    public void playMusic(String path) {
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    nextMusic();
                }
            });
        } catch (IOException e) {
        }
    }

