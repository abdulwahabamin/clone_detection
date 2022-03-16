    @Override
    public void onMediaBrowserChildrenLoaded(List<MediaBrowserCompat.MediaItem> items) {
        Log.d(TAG, "onMediaBrowserChildrenLoaded:called");

        mLastPlaybackState = mMediaBrowserManager.getMediaController().getPlaybackState();
        updatePlaybackState();
        displayMetadata(mMediaBrowserManager.getMediaController().getMetadata());
        updateShuffleMode(mMediaBrowserManager.getMediaController().isShuffleModeEnabled());
        updateRepeatMode(mMediaBrowserManager.getMediaController().getRepeatMode());
    }

