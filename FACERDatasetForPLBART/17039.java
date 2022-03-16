    private MediaMetadataCompat buildAlbumMetadata(Cursor cursor) {
        return new MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, cursor.getString(0))
                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM, cursor.getString(1))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, cursor.getString(1))
                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, cursor.getString(2))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY, cursor.getString(3))
                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, cursor.getString(4))
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, cursor.getString(4))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_FIRST_YEAR, cursor.getString(5))
                .putString(MusicProviderSource.CUSTOM_METADATA_KEY_LAST_YEAR, cursor.getString(6))
                .putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS,
                        Long.parseLong(cursor.getString(7)))
                //.putLong(MediaMetadataCompat.METADATA_KEY_YEAR,
                //        Integer.parseInt(cursor.getString(6)))
                .build();
    }

