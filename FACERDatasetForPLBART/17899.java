    @Override
    public void onQueueItemClick(MediaSessionCompat.QueueItem item) {
        mMediaBrowserManager
                .getMediaController()
                .getTransportControls()
                .skipToQueueItem(item.getQueueId());
    }

