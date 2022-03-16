    /**
     * Updates cities ordering values after city rearranging.
     *
     * @param cityOrderFrom old position of the dragged city
     * @param cityOrderTo   new position of the dragged city
     */
    void dragCity(int cityOrderFrom, int cityOrderTo) {
        if (cityOrderFrom == cityOrderTo) {
            return;
        }
        if (cityOrderFrom < 0 || cityOrderTo < 0) {
            throw new IllegalArgumentException("Unexpected city orders: " + cityOrderFrom + ", " +
                    cityOrderTo);
        }

        String sortOrder = CityTable.COLUMN_ORDERING_VALUE + " DESC";
        Cursor cursor = context.getContentResolver().query(
                WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
                new String[]{CityTable._ID, CityTable.COLUMN_CITY_ID,
                        CityTable.COLUMN_ORDERING_VALUE},
                null, null, sortOrder);
        if (cursor == null) {
            return;
        }

        if (cityOrderFrom == 0 || cityOrderTo == 0) {
            // if the top city in the table changes, we update shared prefs
            cursor.moveToPosition(cityOrderFrom == 0 ? 1 : cityOrderFrom);
            int columnIndexForCityOwmId = cursor.getColumnIndexOrThrow(CityTable.COLUMN_CITY_ID);
            int topCityId = cursor.getInt(columnIndexForCityOwmId);
            SharedPrefsHelper.putCityIdIntoSharedPrefs(context, topCityId, true);
        }

        int columnIndexForOrderingValue = cursor.getColumnIndexOrThrow(CityTable.
                COLUMN_ORDERING_VALUE);
        if (cityOrderFrom < cityOrderTo) {
            // city dragged down
            cursor.moveToPosition(cityOrderTo);
            long orderingValueForCityOrderTo = cursor.getLong(columnIndexForOrderingValue);
            long newOrderingValueForCityOrderFrom = orderingValueForCityOrderTo - 1;

            long maxOrderingValueForNextCityInTable = newOrderingValueForCityOrderFrom - 1;
            while (cursor.moveToNext()) {
                long currentOrderingValueForNextCityInTable = cursor.getLong(
                        columnIndexForOrderingValue);
                if (currentOrderingValueForNextCityInTable > maxOrderingValueForNextCityInTable) {
                    long newOrderingValueForNextCityInTable = maxOrderingValueForNextCityInTable;
                    updateLastQueryTime(cursor, newOrderingValueForNextCityInTable);
                    maxOrderingValueForNextCityInTable--;
                } else {
                    break;
                }
            }

            cursor.moveToPosition(cityOrderFrom);
            updateLastQueryTime(cursor, newOrderingValueForCityOrderFrom);
        } else {
            // city dragged up
            cursor.moveToPosition(cityOrderTo);
            long orderingValueForCityOrderTo = cursor.getLong(columnIndexForOrderingValue);
            long newOrderingValueForCityOrderFrom = orderingValueForCityOrderTo + 1;

            long minOrderingValueForPreviousCityInTable = newOrderingValueForCityOrderFrom + 1;
            while (cursor.moveToPrevious()) {
                long currentOrderingValueForPreviousCityInTable = cursor.getLong(
                        columnIndexForOrderingValue);
                if (currentOrderingValueForPreviousCityInTable <
                        minOrderingValueForPreviousCityInTable) {
                    long newOrderingValueForPreviousCityInTable =
                            minOrderingValueForPreviousCityInTable;
                    updateLastQueryTime(cursor, newOrderingValueForPreviousCityInTable);
                    minOrderingValueForPreviousCityInTable++;
                } else {
                    break;
                }
            }

            cursor.moveToPosition(cityOrderFrom);
            updateLastQueryTime(cursor, newOrderingValueForCityOrderFrom);
        }

        cursor.close();
    }

