    @Override
    Cursor getMediaStoreCursor() {
        String[] projection = {
                MediaStore.Audio.Albums._ID,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.ALBUM_ART,
                MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.Albums.NUMBER_OF_SONGS
        };

        return resolver.query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, projection,
                null, null, null);
    }

