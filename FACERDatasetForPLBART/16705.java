    private MediaBrowserCompat.MediaItem createPlayableMediaItem(String category, String subCategory,
                                                                 MediaMetadataCompat metadata) {
        String musicId = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
        String hierarchyAwareMediaID = MediaIDHelper.createMediaID(musicId, category, subCategory);
        MediaMetadataCompat copy = new MediaMetadataCompat.Builder(metadata)
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, hierarchyAwareMediaID)
                .build();

        return new MediaBrowserCompat.MediaItem(copy.getDescription(),
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE);

    }

