    private MediaMetadataCompat buildArtistMetadata(Cursor cursor) {
        return new MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, cursor.getString(0))
                .putString(MediaMetadataCompat.METADATA_KEY_ARTIST, cursor.getString(1))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, cursor.getString(1))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY, cursor.getString(2))
                .putLong(MusicProviderSource.CUSTOM_METADATA_KEY_NUM_ALBUMS,
                        Integer.parseInt(cursor.getString(3)))
                .putLong(MusicProviderSource.CUSTOM_METADATA_KEY_NUM_TRACKS,
                        Integer.parseInt(cursor.getString(4)))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE,
                        cursor.getString(4)+" tracks")
                .build();
    }

