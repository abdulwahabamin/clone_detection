    /**
     * {@inheritDoc}
     */
    @Override
    public Uri insert(Uri url, ContentValues initialValues) {
        if (sURLMatcher.match(url) != BOOKMARKS
                && sURLMatcher.match(url) != HISTORY) {
            throw new IllegalArgumentException("Cannot insert into URL: " + url); //$NON-NLS-1$
        }

        // Add the bookmark
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        String tablename = null;
        Uri uri = null;

        if (sURLMatcher.match(url) == BOOKMARKS) {
            tablename = "bookmarks";
            uri = Bookmark.Columns.CONTENT_URI;
        } else {
            tablename = "history";
            uri = History.Columns.CONTENT_URI;
        }
        long rowId = db.insert(tablename, null, initialValues); //$NON-NLS-1$
        if (rowId < 0) {
            throw new SQLException("Failed to insert row"); //$NON-NLS-1$
        }
        if (DEBUG) {
            Log.v(TAG, "Added" + tablename + "rowId = " + rowId); //$NON-NLS-1$
        }
        Uri newUrl = ContentUris.withAppendedId(uri, rowId);

        // Notify changes
        getContext().getContentResolver().notifyChange(newUrl, null);
        return newUrl;
    }

