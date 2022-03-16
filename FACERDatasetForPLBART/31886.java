    public void deleteRecordFromTable(Integer recordId) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = CurrentWeatherContract.CurrentWeather._ID + " = ?";
        String[] selectionArgs = {recordId.toString()};
        db.delete(CurrentWeatherContract.CurrentWeather.TABLE_NAME, selection, selectionArgs);
    }

