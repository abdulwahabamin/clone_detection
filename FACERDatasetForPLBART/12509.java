    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
        if (DEBUG) {
            Log.v(TAG, "Upgrading bookmarks database from version " + //$NON-NLS-1$
                oldVersion + " to " + currentVersion); //$NON-NLS-1$
        }
        if (oldVersion < 2) {
            createHistoryTable(db);
        }
    }

