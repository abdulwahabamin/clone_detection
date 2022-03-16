    @Override
    public void addMyCity(final String cityId) {
        MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<MyCity> myCities = getMyCities();
                for (MyCity mycity : myCities) {
                    if (mycity.cityId.equals(cityId)) {
                        return;
                    }
                }

                WeatherDatabaseHelper databaseHelper = MyApplication.getInstance().getWeatherDatabaseHelper();
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(WeatherDatabaseHelper.CityColumns.CITY_ID, cityId);
                values.put(WeatherDatabaseHelper.MyCityColumns.INDEX, String.valueOf(myCities.size() + 1));
                db.insert(WeatherDatabaseHelper.TABLE_CHINA_MY_CITY, "", values);
            }
        });
    }

