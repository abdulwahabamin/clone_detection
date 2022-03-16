    /**
     * create a mediaitem for search results
     * @param metadata metadata from which media item will be created
     * @param byMediaId root media id for creating hierarchy aware mediaid
     * @return built mediaitem
     */
    private MediaBrowserCompat.MediaItem createSearchMediaItem(
            MediaMetadataCompat metadata,
            String byMediaId) {

        if (byMediaId.equals(MediaIdHelper.MEDIA_ID_ALL_SONGS)) {
            Bundle extras = new Bundle();

            extras.putString(MediaMetadataCompat.METADATA_KEY_ARTIST,
                    metadata.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
            extras.putString(MediaMetadataCompat.METADATA_KEY_ALBUM,
                    metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
            extras.putLong(MediaMetadataCompat.METADATA_KEY_DURATION,
                    metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            extras.putString(
                    MusicProviderSource.CUSTOM_METADATA_KEY_SEARCH_ITEM_TYPE,
                    MusicProviderSource.SEARCH_RESULT_ITEM_TYPE_SONG);

            String hierarchyAwareMediaId;

            hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                    metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID),
                    byMediaId);

            MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder()
                    .setExtras(extras)
                    .setMediaId(hierarchyAwareMediaId)
                    .setTitle(metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE))
                    .setSubtitle(metadata.getString(
                            MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE));

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

        } else if (byMediaId.equals(MediaIdHelper.MEDIA_ID_ALBUMS)) {
            return createSearchBrowsableMediaItemForAlbum(metadata);
        } else if (byMediaId.equals(MediaIdHelper.MEDIA_ID_ARTISTS)) {
            return createSearchBrowsableMediaItemForArtist(metadata);
        }

        return null;
    }

