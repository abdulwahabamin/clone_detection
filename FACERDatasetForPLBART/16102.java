    @Override
    String createTableQuery() {
        return "CREATE TABLE " + TABLE_NAME + "("
                + BaseColumns._ID + " INTEGER" + ", "
                + BaseColumns._COUNT + " INTEGER" + ", "
                + Columns.SONG_ID + " INTEGER" + ", "
                + Columns.ALBUM_ID + " INTEGER" + ", "
                + Columns.ARTIST_ID + " INTEGER" + ", "
                + Columns.BOOKMARK + " INTEGER" + ", "
                + Columns.DATE_ADDED + " INTEGER" + ", "
                + Columns.DATE_MODIFIED + " INTEGER" + ", "
                + Columns.DURATION + " INTEGER" + ", "
                + Columns.FILE_PATH + " TEXT" + ", "
                + Columns.SIZE + " INTEGER" + ", "
                + Columns.TITLE + " TEXT" + ", "
                + Columns.TRACK + " INTEGER" + ", "
                + Columns.YEAR + " INTEGER" + ", "
                + Columns.IS_REMOTE + " INTEGER" + ", "
                + Columns.REMOTE_USERNAME + " TEXT" + ")";
    }

