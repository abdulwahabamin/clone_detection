    @Override
    public void onSongSearchResultClick(MediaBrowserCompat.MediaItem item) {
        mMediaBrowserManager
                .getMediaController()
                .getTransportControls()
                .playFromMediaId(item.getMediaId(), null);
        mSelectedItemPublishSubject.onNext(item);
    }

