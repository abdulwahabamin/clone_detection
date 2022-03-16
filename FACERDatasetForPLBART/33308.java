    /**
     * Obtains the Open Weather Map city ID for the specified list position.
     *
     * @param position the city list position
     * @return Open Weather Map city ID, or -1 if the city list does not contain the
     * specified position
     */
    int getCityId(int position) {
        Cursor cursor = getCursor();
        if (cursor.moveToPosition(position)) {
            return cursor.getInt(cursor.getColumnIndex(CityTable.COLUMN_CITY_ID));
        }
        return CityTable.CITY_ID_DOES_NOT_EXIST;
    }

