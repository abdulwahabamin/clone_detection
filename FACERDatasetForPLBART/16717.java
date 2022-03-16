    private MediaBrowserCompat.MediaItem createBrowsableMediaItemForSubCategory(String category,
                                                                                String subCategory,
                                                                                MediaMetadataCompat metadata) {
        String hierarchyAwareMediaID = MediaIDHelper.createMediaID(null, category, subCategory);
        MediaMetadataCompat copy = new MediaMetadataCompat.Builder(metadata)
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, hierarchyAwareMediaID)
                .build();

        return new MediaBrowserCompat.MediaItem(copy.getDescription(),
                MediaBrowserCompat.MediaItem.FLAG_BROWSABLE);
    }

