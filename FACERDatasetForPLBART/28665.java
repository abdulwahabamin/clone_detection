    public synchronized boolean isCityWatched(int cityId) {
        SQLiteDatabase database = this.getReadableDatabase();

        String query = "SELECT " + CITIES_TO_WATCH_CITY_ID +
                " FROM " + TABLE_CITIES_TO_WATCH +
                " WHERE " + CITIES_TO_WATCH_CITY_ID + " = ?";

        String[] params = {String.valueOf(cityId)};
        Cursor cursor = database.rawQuery(query, params);

        boolean result = false;

        if (cursor.moveToFirst()) {
            result = !cursor.isNull(0);
        }

        return result;
    }

