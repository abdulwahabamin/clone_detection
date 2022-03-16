    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_FAVORITES = "CREATE TABLE IF NOT EXISTS " + AppConstant.TABLE_FAVORITES + "("
                + AppConstant.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + AppConstant.MEDIA_ID + " INTEGER NOT NULL, "
                + AppConstant.CR_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL)";

        db.execSQL(CREATE_TABLE_FAVORITES);
    }

