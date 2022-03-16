    @Override
    public void onMediaItemSelected(MediaBrowserCompat.MediaItem item) {
        FireLog.d(TAG, "(++) onMediaItemSelected, mediaitem=" + item);
        if (item.isPlayable()) {
            MediaControllerCompat.getMediaController(this).getTransportControls()
                    .playFromMediaId(item.getMediaId(), null);
        }
    }

