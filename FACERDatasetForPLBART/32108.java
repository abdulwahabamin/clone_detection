    public void deleteRecordByLocation(Location location) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = WeatherForecastContract.WeatherForecast.COLUMN_NAME_LOCATION_ID + " = ?";
        String[] selectionArgs = {location.getId().toString()};
        db.delete(WeatherForecastContract.WeatherForecast.TABLE_NAME, selection, selectionArgs);
    }

