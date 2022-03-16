    private static MediaSessionCompat.QueueItem getQueueItem(@NonNull MediaMetadataCompat metadata,
                                                             @NonNull String...rootId) {
        String hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID),
                rootId);

        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder()
                .setMediaId(hierarchyAwareMediaId)
                .setTitle(metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE))
                .setSubtitle(metadata.getString(
                        MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE));
        MediaDescriptionCompat description = builder.build();

        return new MediaSessionCompat.QueueItem(description, UniqueIdGenerator.getId());
    }

