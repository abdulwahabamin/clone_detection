    @Override
    public synchronized void reStoreMyCitiesIndex(final List<MyCity> myCities) {
        MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                for (MyCity myCity : myCities) {
                    ContentValues values = new ContentValues();
                    values.put(WeatherDatabaseHelper.CityColumns.CITY_ID,myCity.cityId);
                    values.put(WeatherDatabaseHelper.MyCityColumns.INDEX,myCity.index);
                    Log.d("weather","  city id : " + myCity.cityId + "   index : " + myCity.index);
                    SQLiteDatabase db = MyApplication.getInstance().getWeatherDatabaseHelper().getWritableDatabase();
                    db.update(WeatherDatabaseHelper.TABLE_CHINA_MY_CITY, values, WeatherDatabaseHelper.CityColumns.CITY_ID+"=?",new String[]{myCity.cityId});
                }
            }
        });
    }

