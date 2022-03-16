    @Override
    Cursor getMediaStoreCursor() {
        String[] projection = {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS
        };

        return resolver.query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, projection,
                null, null, null);
    }

