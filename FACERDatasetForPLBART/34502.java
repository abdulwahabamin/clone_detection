    @Override
    public void searchCities(final String key, Action1<List<CityData>> action) {
        Observable.create(new Observable.OnSubscribe<List<CityData>>() {
            @Override
            public void call(final Subscriber<? super List<CityData>> subscriber) {
                MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<CityData> cities = null;
                        WeatherDatabaseHelper databaseHelper = MyApplication.getInstance().getWeatherDatabaseHelper();
                        SQLiteDatabase db = databaseHelper.getWritableDatabase();
                        String where = WeatherDatabaseHelper.CityColumns.CITY_NAME + "=? OR " + WeatherDatabaseHelper.CityColumns.CITY_NAME_PINYIN + "=? OR ";
                        StringBuilder sb = new StringBuilder();
                        for(int i = 0;i<key.length();i++){
                            sb.append(key.substring(i,i+1)).append("%");
                        }
                        where += WeatherDatabaseHelper.CityColumns.CITY_NAME_PINYIN + " LIKE '" + sb.toString() + "'";
                        //Log.d("weather","where : " + where);

                        Cursor c = db.query(WeatherDatabaseHelper.TABLE_CHINA_CITIES, CITY_ALL_PROJECTION, where, new String[]{key,key}, null, null, null);
                        if (c != null) {
                            try {
                                cities = new ArrayList<CityData>();
                                while(c.moveToNext()){
                                    CityData city = new CityData();
                                    cursor2City(city,c);
                                    cities.add(city);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                c.close();
                            }
                        }
                        subscriber.onStart();
                        subscriber.onNext(cities);
                    }
                });

            }
        }).subscribe(action);
    }

