    public void deleteRecordByLocation(Location location) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LOCATION_ID + " = ?";
        String[] selectionArgs = {location.getId().toString()};
        db.delete(CurrentWeatherContract.CurrentWeather.TABLE_NAME, selection, selectionArgs);
    }

