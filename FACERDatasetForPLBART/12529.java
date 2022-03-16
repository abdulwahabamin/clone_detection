    /**
     * {@inheritDoc}
     */
    @Override
    public Cursor query(Uri url, String[] projectionIn, String selection,
            String[] selectionArgs, String sort) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Generate the body of the query
        int match = sURLMatcher.match(url);
        switch (match) {
            case BOOKMARKS:
                qb.setTables("bookmarks"); //$NON-NLS-1$
                break;
            case BOOKMARKS_ID:
                qb.setTables("bookmarks"); //$NON-NLS-1$
                qb.appendWhere("_id="); //$NON-NLS-1$
                qb.appendWhere(url.getPathSegments().get(1));
                break;
            case HISTORY:
                qb.setTables("history"); //$NON-NLS-1$
                break;
            case HISTORY_ID:
                qb.setTables("history"); //$NON-NLS-1$
                qb.appendWhere("_id="); //$NON-NLS-1$
                qb.appendWhere(url.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + url); //$NON-NLS-1$
        }

        // Open the database
        SQLiteDatabase db = this.mOpenHelper.getReadableDatabase();
        Cursor cursor = qb.query(db, projectionIn, selection, selectionArgs,
                              null, null, sort);
        if (cursor == null) {
            if (DEBUG) {
                Log.v(TAG, "Bookmarks.query: failed"); //$NON-NLS-1$
            }
        } else {
            cursor.setNotificationUri(getContext().getContentResolver(), url);
        }

        return cursor;
    }

