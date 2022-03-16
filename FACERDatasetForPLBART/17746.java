    @Override
    public void onMediaBrowserChildrenLoaded(List<MediaBrowserCompat.MediaItem> items) {
        Log.d(TAG, "onMediaBrowserChildrenLoaded:called");

        PlaybackStateCompat playbackState =
                mMediaBrowserManager.getMediaController().getPlaybackState();

        if (playbackState != null) {
            if (playbackState.getState() == PlaybackStateCompat.STATE_PAUSED
                    || playbackState.getState() == PlaybackStateCompat.STATE_PLAYING) {
                if (mMvpView.isSlidingUpPaneHidden()) {
                    mMvpView.setSlidingUpPaneCollapsed();
                }
            }
        }
    }

