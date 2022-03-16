    @SuppressWarnings("WeakerAccess")
    public void setQueueFromMediaId(String mediaId) {
        Log.d(TAG, "setQueueFromMediaId:called");
        if (isQueueReusable(mediaId)) {
            Log.d(TAG, "setQueueFromMediaId:queue is reusable");
            setCurrentQueueItem(mediaId);
        } else {
            Log.d(TAG, "setQueueFromMediaId:queue is not reusable");
            setCurrentQueue("now playing",
                    QueueHelper.getPlayingQueue(mediaId, mMusicProvider, mPlaylistsManager),
                    mediaId);
        }
        updateMetadata();
    }

