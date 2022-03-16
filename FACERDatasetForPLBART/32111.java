    public WeatherForecastRecord getWeatherForecast(long locationId) {

        checkVersionOfStoredForecastInDb();

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                WeatherForecastContract.WeatherForecast.COLUMN_NAME_WEATHER_FORECAST,
                WeatherForecastContract.WeatherForecast.COLUMN_NAME_LAST_UPDATED_IN_MS
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                WeatherForecastContract.WeatherForecast.TABLE_NAME,
                projection,
                WeatherForecastContract.WeatherForecast.COLUMN_NAME_LOCATION_ID + "=" + locationId,
                null,
                null,
                null,
                null
            );

            if (cursor.moveToNext()) {
                CompleteWeatherForecast completeWeatherForecast = getCompleteWeatherForecastFromBytes(
                        cursor.getBlob(cursor.getColumnIndexOrThrow(WeatherForecastContract.WeatherForecast.COLUMN_NAME_WEATHER_FORECAST)));
                if (completeWeatherForecast == null) {
                    return null;
                }
                return new WeatherForecastRecord(
                        cursor.getLong(cursor.getColumnIndexOrThrow(WeatherForecastContract.WeatherForecast.COLUMN_NAME_LAST_UPDATED_IN_MS)),
                        completeWeatherForecast);
            } else {
                return null;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

