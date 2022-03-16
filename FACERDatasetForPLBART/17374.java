    /**
     * to create a playable mediaitem
     * @param metadata metadata from which mediaitem will be created
     * @param byMediaId root media id if which media item is to be created
     * @param byMetadataKey metadata key for creating a hierarchy aware mediaid
     * @return built mediaitem
     */
    private MediaBrowserCompat.MediaItem createMediaItem(
            MediaMetadataCompat metadata,
            String byMediaId,
            String byMetadataKey) {

        Bundle extras = new Bundle();

        extras.putString(MediaMetadataCompat.METADATA_KEY_ARTIST,
                metadata.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        extras.putString(MediaMetadataCompat.METADATA_KEY_ALBUM,
                metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        extras.putLong(MediaMetadataCompat.METADATA_KEY_DURATION,
                metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        extras.putLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER,
                metadata.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));

        String hierarchyAwareMediaId, subtitle="";

        if (byMediaId.equals(MediaIdHelper.MEDIA_ID_ALL_SONGS)) {
            hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                    metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID),
                    byMediaId);
            subtitle = metadata.getString(
                    MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE);
        } else {
            hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                    metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID),
                    byMediaId,
                    metadata.getString(byMetadataKey));

            if (byMediaId.startsWith(MediaIdHelper.MEDIA_ID_ARTISTS)) {
                subtitle = metadata.getString(
                        MediaMetadataCompat.METADATA_KEY_ALBUM);
            } else if (byMediaId.startsWith(MediaIdHelper.MEDIA_ID_ALBUMS)) {
                subtitle = metadata.getString(
                        MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE);
            }
        }

        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder()
                .setExtras(extras)
                .setMediaId(hierarchyAwareMediaId)
                .setTitle(metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE))
                .setSubtitle(subtitle);

        if (metadata.getString(
                MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI) != null) {
            builder.setIconUri(
                    Uri.parse(
                            metadata.getString(
                                    MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI)));
        }

        MediaDescriptionCompat descriptionCompat = builder.build();

        return new MediaBrowserCompat.MediaItem(descriptionCompat,
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE);

    }

