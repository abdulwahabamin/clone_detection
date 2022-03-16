    /**
     * Methods for TABLE_CITIES_TO_WATCH
     */
    public synchronized void addCityToWatch(CityToWatch city) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CITIES_TO_WATCH_CITY_ID, city.getCityId());
        values.put(CITIES_TO_WATCH_COLUMN_RANK, city.getRank());

        database.insert(TABLE_CITIES_TO_WATCH, null, values);
        database.close();
    }

