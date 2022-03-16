    @Override
    public void onRepeatButtonClick() {
        int curRepeatMode = mMediaBrowserManager.getMediaController().getRepeatMode();
        switch (curRepeatMode) {
            case PlaybackStateCompat.REPEAT_MODE_NONE:
                mMediaBrowserManager
                        .getMediaController()
                        .getTransportControls()
                        .setRepeatMode(PlaybackStateCompat.REPEAT_MODE_ALL);
                break;
            case PlaybackStateCompat.REPEAT_MODE_ALL:
                mMediaBrowserManager
                        .getMediaController()
                        .getTransportControls()
                        .setRepeatMode(PlaybackStateCompat.REPEAT_MODE_ONE);
                break;
            case PlaybackStateCompat.REPEAT_MODE_ONE:
                mMediaBrowserManager
                        .getMediaController()
                        .getTransportControls()
                        .setRepeatMode(PlaybackStateCompat.REPEAT_MODE_NONE);
                break;
        }
    }

