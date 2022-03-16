    public synchronized List<City> getCitiesWhereNameLike(String cityNameLetters, int dropdownListLimit) {
        List<City> cities = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();

        String query = "SELECT " + CITIES_ID +
                ", " + CITIES_NAME +
                ", " + CITIES_COUNTRY_CODE +
                ", " + CITIES_POSTAL_CODE +
                " FROM " + TABLE_CITIES +
                " WHERE " + CITIES_NAME +
                " LIKE ?" +
                " ORDER BY " + CITIES_NAME +
                " LIMIT " + dropdownListLimit;

        String[] args = {String.format("%s%%", cityNameLetters)};
        Cursor cursor = database.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setCityId(Integer.parseInt(cursor.getString(0)));
                city.setCityName(cursor.getString(1));
                city.setCountryCode(cursor.getString(2));
                city.setPostalCode(cursor.getString(3));
                cities.add(city);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return cities;

    }

