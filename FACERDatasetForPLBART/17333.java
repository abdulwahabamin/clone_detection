    private boolean setCurrentQueueItem(String mediaId) {
        Log.d(TAG, "getCurrentQueueIndex:called");
        Log.i(TAG, "getCurrentQueueIndex:mediaId="+mediaId);
        int index = QueueHelper.getQueueIndexOf(mediaId, mPlayingQueue);
        return setCurrentQueueIndex(index);
    }

