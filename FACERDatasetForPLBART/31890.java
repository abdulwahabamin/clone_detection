    public void updateLastUpdatedTime(final long locationId, final long weatherUpdateTime) {
        new Thread(new Runnable() {
            public void run() {
                SQLiteDatabase db = getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LAST_UPDATED_IN_MS, weatherUpdateTime);

                db.updateWithOnConflict(
                        CurrentWeatherContract.CurrentWeather.TABLE_NAME,
                        values,
                        CurrentWeatherContract.CurrentWeather.COLUMN_NAME_LOCATION_ID + "=" + locationId,
                        null,
                        SQLiteDatabase.CONFLICT_IGNORE);
            }
        }).start();
    }

