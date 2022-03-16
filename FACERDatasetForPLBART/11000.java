    /**
     * Method that clears the history database.
     */
    private void deleteAllHistorys() {
        getContentResolver().delete(History.Columns.CONTENT_URI, "", null);
    }

