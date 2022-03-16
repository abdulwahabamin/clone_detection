    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DataCache.TABLE_NAME + "(" +
                DataCache.Columns._ID + " INTEGER PRIMARY KEY NOT NULL, " +
                DataCache.Columns.PATH + " TEXT UNIQUE NOT NULL, " +
                DataCache.Columns.SIZE + " LONG NOT NULL)";
        db.execSQL(sql);
    }

