    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CHINA_CITIES + " (" +
                CityColumns._ID + " INTEGER AUTO_INCREMENT PRIMARY KEY," +
                CityColumns.CITY_ID + " TEXT," +
                CityColumns.CITY_NAME + " TEXT," +
                CityColumns.CITY_NAME_PINYIN + " TEXT," +
                CityColumns.CNTY_NAME + " TEXT," +
                CityColumns.LAT + " TEXT," +
                CityColumns.LON + " TEXT," +
                CityColumns.PROV + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CHINA_MY_CITY + " (" +
                CityColumns._ID + " INTEGER AUTO_INCREMENT PRIMARY KEY," +
                CityColumns.CITY_ID + " TEXT," +
                MyCityColumns.INDEX + " TEXT" +
                ");");
    }

