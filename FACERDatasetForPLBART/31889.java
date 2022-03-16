    public void saveWeather(final long locationId,
                            final long weatherUpdateTime,
                            final Weather weather) {
        new Thread(new Runnable() {
            public void run() {
                SQLiteDatabase db = getWritableDatabase();

                WeatherRecord oldWeather = getWeather(locationId);

                ContentValues values = new ContentValues();
                values.put(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_WEATHER, getWeatherAsBytes(weather));
                values.put(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LOCATION_ID, locationId);
                values.put(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LAST_UPDATED_IN_MS, weatherUpdateTime);
                if (oldWeather == null) {
                    db.insert(CurrentWeatherContract.CurrentWeather.TABLE_NAME, null, values);
                } else {
                    db.updateWithOnConflict(CurrentWeatherContract.CurrentWeather.TABLE_NAME,
                            values,
                            CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LOCATION_ID + "=" + locationId,
                            null,
                            SQLiteDatabase.CONFLICT_IGNORE);
                }
            }
        }).start();
    }

