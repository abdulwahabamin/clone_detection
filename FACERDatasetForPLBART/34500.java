    /**
     * �?始化数�?�库中的城市表
     * @param search 城市类型
     *               国内城市：allchina�? 热门城市：hotworld�? 全部城市：allworld
     * @param callback �?始化�?�的回调
     */
    @Override
    public void initCitiesList(String search, final HeWeatherPickerImpl.InitCitiesCallback callback) {
        heWeatherREST.getCitiesAsync(search, HeWeatherREST.API_KEY).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    String body = responseBody.string();
                    Log.d("weather", "body : " + body);
                    HeCitiesIniter initer = new HeCitiesIniter(body);
                    List<CityData> cityDatas = initer.getCityDatas();
                    Log.d("weather", "city size = " + cityDatas.size());
                    WeatherDatabaseHelper databaseHelper = MyApplication.getInstance().getWeatherDatabaseHelper();
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();

                    for (CityData cityData : cityDatas) {
                        ContentValues values = new ContentValues();
                        values.put(WeatherDatabaseHelper.CityColumns.CITY_ID, cityData.city_id);
                        values.put(WeatherDatabaseHelper.CityColumns.CITY_NAME, cityData.cityName);
                        values.put(WeatherDatabaseHelper.CityColumns.CITY_NAME_PINYIN, Trans2PinYin.getInstance().convertAll(cityData.cityName));
                        values.put(WeatherDatabaseHelper.CityColumns.CNTY_NAME, cityData.cntyName);
                        values.put(WeatherDatabaseHelper.CityColumns.LAT, cityData.lat);
                        values.put(WeatherDatabaseHelper.CityColumns.LON, cityData.lon);
                        values.put(WeatherDatabaseHelper.CityColumns.PROV, cityData.prov);
                        Cursor c = db.query(WeatherDatabaseHelper.TABLE_CHINA_CITIES, CITY_ID_PROJECTION, CITY_ID_SELECTION, new String[]{cityData.city_id}, null, null, null);
                        if (c != null) {
                            try {
                                if (c.getCount() > 0) {
                                    // Log.d("weather","  update");
                                    db.update(WeatherDatabaseHelper.TABLE_CHINA_CITIES, values, CITY_ID_SELECTION, new String[]{cityData.city_id});
                                } else {
                                    // Log.d("weather","  insert");
                                    db.insert(WeatherDatabaseHelper.TABLE_CHINA_CITIES, "", values);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                c.close();
                            }
                        } else {
                            // Log.d("weather","  insert");
                            db.insert(WeatherDatabaseHelper.TABLE_CHINA_CITIES, "", values);
                        }
                    }
                    callback.initSuccess();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    callback.initFailure();
                }
            }
        });
    }

