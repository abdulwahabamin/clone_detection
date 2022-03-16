    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
        if (DEBUG) {
            Log.v(TAG, "Upgrading bookmarks database from version " + //$NON-NLS-1$
                oldVersion + " to " + currentVersion + //$NON-NLS-1$
                ", which will destroy all old data"); //$NON-NLS-1$
        }
        db.execSQL("DROP TABLE IF EXISTS bookmarks"); //$NON-NLS-1$
        onCreate(db);
    }

