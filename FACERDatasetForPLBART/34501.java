    @Override
    public void getAllCities(Action1<List<CityData>> action) {
        Observable.create(new Observable.OnSubscribe<List<CityData>>() {
            @Override
            public void call(final Subscriber<? super List<CityData>> subscriber) {
                MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<CityData> cities = null;
                        WeatherDatabaseHelper databaseHelper = MyApplication.getInstance().getWeatherDatabaseHelper();
                        SQLiteDatabase db = databaseHelper.getWritableDatabase();
                        Cursor c = db.query(WeatherDatabaseHelper.TABLE_CHINA_CITIES, CITY_ALL_PROJECTION, null, null, null, null, null);
                        if (c != null) {
                            try {
                                cities = new ArrayList<CityData>();
                                while (c.moveToNext()) {
                                    CityData city = new CityData();
                                    cursor2City(city, c);
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

