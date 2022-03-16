    public static MediaMetadataCompat createPlaylistMetadata(String playlistKey,
                                                             String playlistTitle,
                                                             int noOfSongs,
                                                             int iconDrawableId,
                                                             int playlistColor,
                                                             int playlistType) {
        return new MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, playlistKey)
                .putString(MediaMetadataCompat.METADATA_KEY_TITLE, playlistTitle)
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, playlistTitle)
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, noOfSongs+" Songs")
                .putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, noOfSongs)
                .putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_ICON_DRAWABLE_ID,
                        iconDrawableId)
                .putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_COLOR, playlistColor)
                .putLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_TYPE, playlistType)
                .build();

    }

