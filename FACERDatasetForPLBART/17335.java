    private void setCurrentQueue(String title, List<MediaSessionCompat.QueueItem> newQueue,
                                   String initialMediaId) {
        Log.d(TAG, "setCurrentQueue:called");
        mPlayingQueue = newQueue;

        int index = 0;
        if (initialMediaId != null) {
            index = QueueHelper.getQueueIndexOf(initialMediaId, mPlayingQueue);
        }
        mCurrentIndex = Math.max(index, 0);
        mMetadataUpdateListener.onQueueUpdated(title, newQueue);
    }

