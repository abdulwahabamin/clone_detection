    @Override
    public void onHeartIvClick() {
        Bundle b = new Bundle();
        b.putString(MusicService.KEY_MEDIA_ID, mMetadata.getDescription().getMediaId());
        mMediaBrowserManager
                .getMediaController()
                .sendCommand(MusicService.CMD_FAVOURITES, b, null);
    }

