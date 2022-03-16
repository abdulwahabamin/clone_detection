    public void deleteRecordFromTable(Integer recordId) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = WeatherForecastContract.WeatherForecast._ID + " = ?";
        String[] selectionArgs = {recordId.toString()};
        db.delete(WeatherForecastContract.WeatherForecast.TABLE_NAME, selection, selectionArgs);
    }

