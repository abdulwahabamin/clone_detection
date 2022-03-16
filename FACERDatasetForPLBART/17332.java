    private boolean setCurrentQueueIndex(int index) {
        Log.d(TAG, "getCurrentQueueIndex:called");
        Log.i(TAG, "getCurrentQueueIndex:index="+index);

        if (index >= 0 && index < mPlayingQueue.size()) {
            mCurrentIndex = index;
            mMetadataUpdateListener.onCurrentQueueIndexUpdated(mCurrentIndex);
            return true;
        }

        return false;
    }

