    private void initMediaPlayers() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }

        if (mMediaPlayer2 != null) {
            getMediaPlayer2().release();
            mMediaPlayer2 = null;
        }

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer2 = new MediaPlayer();
        setCurrentMediaPlayer(1);

        getMediaPlayer().reset();
        getMediaPlayer2().reset();

        try {
            mMediaPlayer.setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
            getMediaPlayer2().setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
        } catch (Exception e) {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer2 = new MediaPlayer();
            setCurrentMediaPlayer(1);
        }
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        getMediaPlayer2().setAudioStreamType(AudioManager.STREAM_MUSIC);

    }

