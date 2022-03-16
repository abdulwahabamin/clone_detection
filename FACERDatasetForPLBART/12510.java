    private void createHistoryTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE history (" + //$NON-NLS-1$
                "_id INTEGER PRIMARY KEY," + //$NON-NLS-1$
                "title TEXT," + //$NON-NLS-1$
                "description TEXT);"); //$NON-NLS-1$
    }

