    @Override
    public String createTableQuery() {
        return  "CREATE TABLE " + TABLE_NAME + "("
                + BaseColumns._ID + " INTEGER" + ", "
                + BaseColumns._COUNT + " INTEGER" + ", "
                + Columns.ARTIST_ID + " INTEGER" + ", "
                + Columns.ARTIST_NAME + " TEXT" + ", "
                + Columns.NUMBER_OF_ALBUMS + " INTEGER" + ", "
                + Columns.NUMBER_OF_TRACKS + " INTEGER" + ", "
                + Columns.IS_REMOTE + " INTEGER" + ", "
                + Columns.REMOTE_USERNAME + " TEXT" + ")";
    }

