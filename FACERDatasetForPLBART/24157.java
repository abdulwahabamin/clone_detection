    private Cursor fetchGenre(long id) {
        return getContext().getContentResolver().query(
                MediaStore.Audio.Genres.Members.getContentUri("external", id),
                MEDIA_STORE_MEMBER_CURSOR_COLS,
                MediaStore.Audio.AudioColumns.TITLE + " != ''"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " IS NOT NULL"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " != ''"
                        + " AND " + MediaStore.Audio.AudioColumns.IS_MUSIC + "=1",
                null,
                MediaStore.Audio.Genres.Members.DEFAULT_SORT_ORDER);
    }

