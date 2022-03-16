    /**
     * Obtains the city name stored in the database for the specified list position.
     *
     * @param position city list position
     * @return city name, or null if city list does not contain the specified position
     */
    String getCityName(int position) {
        Cursor cursor = getCursor();
        if (cursor.moveToPosition(position)) {
            return cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_NAME));
        }
        return null;
    }

