    private void updateMetadata() {
        Log.d(TAG, "updateMetadata:called");

        MediaSessionCompat.QueueItem currentMusic = getCurrentMusic();
        if (currentMusic == null) {
            mMetadataUpdateListener.onMetadataRetrieveError();
            return;
        }

        String mediaId = currentMusic.getDescription().getMediaId();
        if (mediaId == null) {
            Log.w(TAG, "updateMetadata:mediaid is null");
            return;
        }

        String musicId = MediaIdHelper.extractMusicIdFromMediaId(mediaId);
        if (musicId == null) {
            Log.w(TAG, "updateMetadata:musicid is null");
            return;
        }

        MediaMetadataCompat metadata = mMusicProvider.getMusic(musicId);
        if (metadata == null) {
            throw new IllegalArgumentException("Invalid musicId " + musicId);
        }

        mMetadataUpdateListener.onMetadataChanged(metadata);
        mMetadataUpdateListener.onCurrentQueueIndexUpdated(mCurrentIndex);
    }

