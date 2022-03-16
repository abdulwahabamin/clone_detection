    protected void setCurrentQueue(List<MediaSessionCompat.QueueItem> newQueue,
                                   String initialMediaId) {
        playingQueue = newQueue;
        int index = 0;
        if (initialMediaId != null) {
            index = QueueHelper.getMusicIndexOnQueue(playingQueue, initialMediaId);
        }
        currentIndex = Math.max(index, 0);
        metadataUpdateListener.onQueueUpdated(newQueue);
    }

