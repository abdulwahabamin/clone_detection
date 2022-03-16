    private void reInitialiseMediaSession(int currentPosition) {
        PlayBackUtil.setCurrentSongPosition(currentPosition);
        mMediaPlayer = PlayBackUtil.setMediaPlayer(getApplicationContext(),
                songDTOs.get(currentPosition).getSongLocation());
        mMediaPlayer.start();
        initMediaSessions();
    }

