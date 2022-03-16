    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        populateSongs(PlayBackUtil.getCurrentPlayList(), PlayBackUtil.getCurrentSongPosition());
    }

