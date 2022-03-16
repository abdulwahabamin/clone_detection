    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bookmarks (" + //$NON-NLS-1$
                   "_id INTEGER PRIMARY KEY," + //$NON-NLS-1$
                   "path TEXT);"); //$NON-NLS-1$
        createHistoryTable(db);
    }

