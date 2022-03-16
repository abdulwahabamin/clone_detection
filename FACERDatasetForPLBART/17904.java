    @Override
    public void onMediaBrowserChildrenLoaded(List<MediaBrowserCompat.MediaItem> items) {
        Log.d(TAG, "onMediaBrowserChildrenLoaded:called");

        mLastPlaybackState = mMediaBrowserManager.getMediaController().getPlaybackState();
        updatePlaybackState();
        mMetadata = mMediaBrowserManager.getMediaController().getMetadata();
        displayMetadata(mMetadata);
        updateQueue(mMediaBrowserManager.getMediaController().getQueue());
        updateShuffleMode(mMediaBrowserManager.getMediaController().isShuffleModeEnabled());
        updateRepeatMode(mMediaBrowserManager.getMediaController().getRepeatMode());

        Bundle b = mMediaBrowserManager.getMediaController().getPlaybackState().getExtras();
        if (b != null) {
            mMvpView.updateQueueIndex(b.getInt(Playback.PLAYBACK_STATE_EXTRA_CURRENT_QUEUE_INDEX));
        }
    }

