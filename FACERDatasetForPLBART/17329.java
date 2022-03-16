    @SuppressWarnings("WeakerAccess")
    public MediaSessionCompat.QueueItem getCurrentMusic() {
        Log.d(TAG, "getCurrentMusic:called");
        if (!QueueHelper.isIndexPlayable(mCurrentIndex, mPlayingQueue)) {
            Log.w(TAG, "getCurrentMusic:index not playable");
            return null;
        }

        return mPlayingQueue.get(mCurrentIndex);
    }

