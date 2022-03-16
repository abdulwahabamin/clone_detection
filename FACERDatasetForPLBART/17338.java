    @SuppressWarnings("WeakerAccess")
    public void shuffleMusic(String mediaId) {
        if (mPlayingQueue != null) {
            ArrayList<MediaSessionCompat.QueueItem> newQueue = new ArrayList<>();
            newQueue.add(QueueHelper.getQueueItem(
                    mediaId,
                    mMusicProvider));
            mPlayingQueue.remove(QueueHelper.getQueueIndexOf(mediaId, mPlayingQueue));
            Collections.shuffle(mPlayingQueue);
            newQueue.addAll(mPlayingQueue);
            mPlayingQueue = newQueue;
            mCurrentIndex = 0;

            mMetadataUpdateListener.onQueueUpdated("now playing", mPlayingQueue);
            mMetadataUpdateListener.onCurrentQueueIndexUpdated(mCurrentIndex);
        }
    }

