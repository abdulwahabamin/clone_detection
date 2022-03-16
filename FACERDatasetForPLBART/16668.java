    public boolean skipQueuePosition(int amount) {
        int index = currentIndex + amount;
        if (index < 0) {
            // skip backwards before the first song will keep you on the first song
            index = 0;
        } else {
            // skip forwards when in last song will cycle back to start of the queue
            index %= playingQueue.size();
        }
        if (!QueueHelper.isIndexPlayable(index, playingQueue)) {
            FireLog.e(TAG, "Cannot increment queue index by " + amount +
                    ". Current=" + currentIndex + " queue length=" + playingQueue.size());
            return false;
        }
        currentIndex = index;
        return true;
    }

