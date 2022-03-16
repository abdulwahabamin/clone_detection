    private MediaBrowserCompat.MediaItem createBrowsableMediaItemForPlaylist(
            MediaMetadataCompat metadata) {

        Bundle extras = new Bundle();

        extras.putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_COLOR,
                metadata.getLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_COLOR));

        extras.putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_ICON_DRAWABLE_ID,
                metadata.getLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_ICON_DRAWABLE_ID));

        extras.putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_TYPE,
                metadata.getLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_TYPE));

        extras.putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS,
                metadata.getLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS));

        String hierarchyAwareMediaId = MediaIdHelper.createMediaId(
                null,
                MediaIdHelper.MEDIA_ID_PLAYLISTS,
                metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)
        );

        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder()
                .setExtras(extras)
                .setMediaId(hierarchyAwareMediaId)
                .setTitle(metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE))
                .setSubtitle(metadata.getString(
                        MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE));

        MediaDescriptionCompat descriptionCompat = builder.build();

        return new MediaBrowserCompat.MediaItem(descriptionCompat,
                MediaBrowserCompat.MediaItem.FLAG_BROWSABLE);
    }

