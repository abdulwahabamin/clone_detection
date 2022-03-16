    @Override
    String createTableQuery() {
        return "CREATE TABLE " + TABLE_NAME + "("
                + BaseColumns._ID + " INTEGER" + ", "
                + BaseColumns._COUNT + " INTEGER" + ", "
                + Columns.ALBUM_ID + " INTEGER" + ", "
                + Columns.ALBUM_NAME + " TEXT" + ", "
                + Columns.ALBUM_ART + " TEXT" + ", "
                + Columns.ARTIST + " TEXT" + ", "
                + Columns.NUMBER_OF_SONGS + " INTEGER" + ", "
                + Columns.IS_REMOTE + " INTEGER" + ", "
                + Columns.REMOTE_USERNAME + " TEXT" + ")";
    }

