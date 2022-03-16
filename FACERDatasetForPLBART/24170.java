    private Cursor fetchAlbums() {
        return getContext().getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Audio.Albums._ID,
                        MediaStore.Audio.Albums.ALBUM,
                        MediaStore.Audio.Albums.NUMBER_OF_SONGS,
                },
                MediaStore.Audio.Albums.ALBUM + " != ''",
                null,
                MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
    }

