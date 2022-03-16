    private Cursor fetchAlbum(long id) {
        return getContext().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                MEDIA_STORE_MEMBER_CURSOR_COLS,
                MediaStore.Audio.AudioColumns.TITLE + " != ''"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " IS NOT NULL"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " != ''"
                        + " AND " + MediaStore.Audio.AudioColumns.ALBUM_ID + "=" + id
                        + " AND " + MediaStore.Audio.AudioColumns.IS_MUSIC + "=1",
                null,
                MediaStore.Audio.AudioColumns.TRACK + ", " + MediaStore.Audio.AudioColumns.TITLE_KEY);
    }

