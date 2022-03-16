    /**
     * Sets the last query time to the current time for all the records with the given row IDs.
     *
     * @param rowIds unique ids of the table records
     */
    public void setLastOverallQueryTimeToCurrentTime(long[] rowIds) {
        ContentResolver contentResolver = context.getContentResolver();
        long currentTime = System.currentTimeMillis();
        ContentValues newValues = new ContentValues();
        newValues.put(CityTable.COLUMN_ORDERING_VALUE, currentTime);
        for (long rowId : rowIds) {
            Uri rowUri = getRowUri(rowId);
            contentResolver.update(rowUri, newValues, null, null);
        }
    }

