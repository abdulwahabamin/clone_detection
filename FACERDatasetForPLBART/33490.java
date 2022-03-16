    /**
     * Sets the last query time for the record to the current time. This is useful when we want a
     * record to appear first in the result set (as results are ordered by the last query time)
     * without requesting weather info from the web; for instance, when the user searches cities
     * already added to the database.
     *
     * @param rowId a unique id of a table record
     */
    public void setLastOverallQueryTimeToCurrentTime(long rowId) {
        long currentTime = System.currentTimeMillis();
        ContentValues newValues = new ContentValues();
        newValues.put(CityTable.COLUMN_ORDERING_VALUE, currentTime);
        Uri rowUri = getRowUri(rowId);
        context.getContentResolver().update(rowUri, newValues, null, null);
    }

