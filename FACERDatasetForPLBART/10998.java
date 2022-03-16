    /**
     * Method that loads the history saved in database.
     */
    private void loadHistory() {
        ContentResolver contentResolver = this.getContentResolver();
        Cursor cursor = contentResolver.query(
                History.Columns.CONTENT_URI,
                History.Columns.HISTORY_QUERY_COLUMNS,
                null, null, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String title = cursor.getString(1);
                    String desc = cursor.getString(2);
                    HistoryItem item = new HistoryItem(title, desc);
                    History history = new History(mHistory.size(), item);

                    mHistory.add(history);
                    mHistorySaved.add(history);
                } while (cursor.moveToNext());
            }
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                // Ignore
            }
        }
    }

