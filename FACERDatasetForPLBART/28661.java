    public synchronized City getCityById(Integer id) {
        SQLiteDatabase database = this.getReadableDatabase();

        String[] args = {id.toString()};

        Cursor cursor = database.rawQuery(
                "SELECT " + CITIES_ID +
                        ", " + CITIES_NAME +
                        ", " + CITIES_COUNTRY_CODE +
                        ", " + CITIES_POSTAL_CODE +
                        " FROM " + TABLE_CITIES +
                        " WHERE " + CITIES_ID + " = ?", args);

        City city = new City();

        if (cursor != null && cursor.moveToFirst()) {

            city.setCityId(Integer.parseInt(cursor.getString(0)));
            city.setCityName(cursor.getString(1));
            city.setCountryCode(cursor.getString(2));
            city.setPostalCode(cursor.getString(3));

            cursor.close();
        }

        return city;
    }

