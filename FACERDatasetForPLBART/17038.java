    private MediaMetadataCompat buildSongMetadata(Cursor cursor) {
        return new MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, cursor.getString(0))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_TRACK_SOURCE, cursor.getString(1))
                .putString(MediaMetadataCompat.METADATA_KEY_DATE, cursor.getString(2))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_DATE_MODIFIED, cursor.getString(3))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_DISPLAY_NAME, cursor.getString(4))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_SIZE, cursor.getString(5))
                .putString(MediaMetadataCompat.METADATA_KEY_TITLE, cursor.getString(6))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, cursor.getString(6))
                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM, cursor.getString(7))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_ID, cursor.getString(8))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY, cursor.getString(9))
                .putString(MediaMetadataCompat.METADATA_KEY_ARTIST, cursor.getString(10))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, cursor.getString(10))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_ID, cursor.getString(11))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY, cursor.getString(12))
                .putString(MediaMetadataCompat.METADATA_KEY_COMPOSER, cursor.getString(13))
                .putLong(MediaMetadataCompat.METADATA_KEY_DURATION,
                        Long.parseLong(cursor.getString(14)))
                .putLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER,
                        Long.parseLong(cursor.getString(15)))
                //.putLong(MediaMetadataCompat.METADATA_KEY_YEAR,
                //        Long.parseLong(cursor.getString(16).trim()))
                .build();
    }

