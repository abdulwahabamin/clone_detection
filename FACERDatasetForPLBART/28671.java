    public synchronized List<Forecast> getForecastForCityByDay(int cityId, Date day) {
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT " + FORECAST_ID + ", " +
                                FORECAST_CITY_ID + ", " +
                                FORECAST_COLUMN_TIME_MEASUREMENT + ", " +
                                FORECAST_COLUMN_FORECAST_FOR + ", " +
                                FORECAST_COLUMN_WEATHER_ID + ", " +
                                FORECAST_COLUMN_TEMPERATURE_CURRENT + ", " +
                                FORECAST_COLUMN_HUMIDITY + ", " +
                                FORECAST_COLUMN_PRESSURE + ", " +
                                CITIES_NAME +
                                " FROM " + TABLE_FORECAST +
                                " INNER JOIN " + TABLE_CITIES + " ON " + CITIES_ID + " = " + FORECAST_CITY_ID +
                                " WHERE " + FORECAST_CITY_ID + " = ? AND " + FORECAST_COLUMN_FORECAST_FOR + " = ?",
                new String[]{String.valueOf(cityId)});

        List<Forecast> list = new ArrayList<>();
        Forecast forecast = null;

        if (cursor != null && cursor.moveToFirst()) {
            do {
                forecast = new Forecast();
                forecast.setId(Integer.parseInt(cursor.getString(0)));
                forecast.setCity_id(Integer.parseInt(cursor.getString(1)));
                forecast.setTimestamp(Long.parseLong(cursor.getString(2)));
                forecast.setForecastTime(new Date(Long.parseLong(cursor.getString(3))));
                forecast.setWeatherID(Integer.parseInt(cursor.getString(4)));
                forecast.setTemperature(Float.parseFloat(cursor.getString(5)));
                forecast.setHumidity(Float.parseFloat(cursor.getString(6)));
                forecast.setPressure(Float.parseFloat(cursor.getString(7)));
                forecast.setCity_name(cursor.getString(8));
                list.add(forecast);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return list;
    }

