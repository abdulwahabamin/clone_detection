    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CITIES);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_FORECASTS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_CURRENT_WEATHER);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CITIES_TO_WATCH);

        // create new tables
        onCreate(db);
    }

