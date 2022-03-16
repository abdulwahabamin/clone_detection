    public static List<MediaSessionCompat.QueueItem> getPlayingQueue(String mediaId,
                                                                     MusicProvider musicProvider) {
        FireLog.d(TAG, "(++) getPlayingQueue: mediaId=" + mediaId);

        // extract the browsing hierarchy from the media ID:
        String[] hierarchy = MediaIDHelper.getHierarchy(mediaId);

        if (hierarchy.length != 2) {
            FireLog.e(TAG, "Could not build a playing queue for this mediaId: " + mediaId);
            return null;
        }

        String categoryType = hierarchy[0];
        String categoryValue = hierarchy[1];
        FireLog.d(TAG, "Creating playing queue for " + categoryType + ",  " + categoryValue);

        List<MediaMetadataCompat> tracks = musicProvider.getAllRetrievedMetadata();

        if (tracks == null) {
            FireLog.e(TAG, "Unrecognized category type: " + categoryType + " for media " + mediaId);
            return null;
        }

        return convertToQueue(tracks, hierarchy[0], hierarchy[1]);
    }

