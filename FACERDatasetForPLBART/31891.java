    public WeatherRecord getWeather(long locationId) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                CurrentWeatherContract.CurrentWeather.COLUMN_NAME_WEATHER,
                CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LAST_UPDATED_IN_MS
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    CurrentWeatherContract.CurrentWeather.TABLE_NAME,
                    projection,
                    CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LOCATION_ID + "=" + locationId,
                    null,
                    null,
                    null,
                    null
            );

            if (cursor.moveToNext()) {
                Weather weather = getWeatherFromBytes(cursor.getBlob(cursor.getColumnIndexOrThrow(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_WEATHER)));
                return new WeatherRecord(
                        cursor.getLong(cursor.getColumnIndexOrThrow(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LAST_UPDATED_IN_MS)),
                        weather);
            } else {
                return null;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

