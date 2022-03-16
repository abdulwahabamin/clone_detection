    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        removePlayerListeners();
        mediaPlayer = PlayBackUtil.setMediaPlayer(getContext().getApplicationContext(),
                rhythmSong.getSongLocation());
        setPlayerListeners();
        return false;
    }

