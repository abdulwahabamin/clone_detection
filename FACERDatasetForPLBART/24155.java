    private Cursor fetchFolder(String folder) {
        return getContext().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                MEDIA_STORE_MEMBER_CURSOR_COLS,
                MediaStore.Audio.AudioColumns.TITLE + " != ''"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " IS NOT NULL"
                        + " AND " + MediaStore.Audio.AudioColumns.DATA + " LIKE ?"
                        + " AND " + MediaStore.Audio.AudioColumns.IS_MUSIC + "=1",
                new String[] { folder + "%" },
                MediaStore.Audio.AudioColumns.DATA);
    }

