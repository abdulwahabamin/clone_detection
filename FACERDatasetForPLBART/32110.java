    public void saveWeatherForecast(long locationId, long weatherUpdateTime, CompleteWeatherForecast completeWeatherForecast) {
        SQLiteDatabase db = getWritableDatabase();

        WeatherForecastRecord oldWeatherForecast = getWeatherForecast(locationId);

        ContentValues values = new ContentValues();
        values.put(WeatherForecastContract.WeatherForecast.COLUMN_NAME_WEATHER_FORECAST,
                   getCompleteWeatherForecastAsBytes(completeWeatherForecast));
        values.put(WeatherForecastContract.WeatherForecast.COLUMN_NAME_LOCATION_ID, locationId);
        values.put(WeatherForecastContract.WeatherForecast.COLUMN_NAME_LAST_UPDATED_IN_MS, weatherUpdateTime);
        if (oldWeatherForecast == null) {
            db.insert(WeatherForecastContract.WeatherForecast.TABLE_NAME, null, values);
        } else {
            db.updateWithOnConflict(WeatherForecastContract.WeatherForecast.TABLE_NAME,
                    values,
                    WeatherForecastContract.WeatherForecast.COLUMN_NAME_LOCATION_ID + "=" + locationId,
                    null,
                    SQLiteDatabase.CONFLICT_IGNORE);
        }
    }

