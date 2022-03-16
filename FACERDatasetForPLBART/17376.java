    /**
     * create artist browsable mediaitem for search results
     * @param metadata metadata from which mediaitem will be created
     * @return build mediaitem
     */
    private MediaBrowserCompat.MediaItem createSearchBrowsableMediaItemForArtist(
            MediaMetadataCompat metadata) {

        String hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                null,
                MediaIdHelper.MEDIA_ID_ARTISTS,
                metadata.getString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY)
        );

        Bundle extras = new Bundle();
        extras.putString(
                MusicProviderSource.CUSTOM_METADATA_KEY_SEARCH_ITEM_TYPE,
                MusicProviderSource.SEARCH_RESULT_ITEM_TYPE_ARTIST);

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
                MediaBrowserCompat.MediaItem.FLAG_BROWSABLE);
    }

