    @SuppressWarnings("WeakerAccess")
    public boolean skipQueuePosition(int amount) {
        Log.d(TAG, "skipQueuePosition:called");
        int index = mCurrentIndex + amount;

        if (index < 0) {
            // skip backwards before the first song will keep you on the first song
            index = 0;
        } else {
            // skip forwards when in last song will cycle back to start of the queue
            index %= mPlayingQueue.size();
        }

        if (!QueueHelper.isIndexPlayable(index, mPlayingQueue)) {
            Log.e(TAG, "Cannot increment queue index by "+ amount +
                    ". Current=" + mCurrentIndex + " queue length=" + mPlayingQueue.size());
            return false;
        }

        mCurrentIndex = index;
        updateMetadata();
        return true;
    }

