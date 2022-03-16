    /**
     * Method that saves the history to the database.
     *
     * @param historyItem
     * @return boolean
     */
    private boolean addHistory(HistoryNavigable historyItem) {
        ContentValues values = new ContentValues(2);
        values.put(History.Columns.TITLE, historyItem.getTitle());
        values.put(History.Columns.DESCRIPTION, historyItem.getDescription());

        final Uri uri = getContentResolver()
                .insert(History.Columns.CONTENT_URI, values);
        if ((int) ContentUris.parseId(uri) == -1) {
            if (DEBUG) {
                Log.e(TAG, "Error inserting the navigation history");
            }
            return false;
        }

        return true;
    }

