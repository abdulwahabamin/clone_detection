    private void setCurrentQueueIndex(int index) {
        if (index >= 0 && index < playingQueue.size()) {
            currentIndex = index;
            metadataUpdateListener.onCurrentQueueIndexUpdated(currentIndex);
        }
    }

