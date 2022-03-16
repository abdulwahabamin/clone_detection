    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_CITIES + " (" +
                KEY_CITY + " TEXT," +
                KEY_ID + " INTEGER PRIMARY KEY" + ");";
        db.execSQL(CREATE_QUESTION_TABLE);
    }

