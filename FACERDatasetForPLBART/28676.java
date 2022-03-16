    public synchronized void deleteForecast(Forecast forecast) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_FORECAST, FORECAST_ID + " = ?",
                new String[]{Integer.toString(forecast.getId())});
        database.close();
    }

