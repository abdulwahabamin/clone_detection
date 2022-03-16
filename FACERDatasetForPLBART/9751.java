    /**
     * {@inheritDoc}
     */
    @Override
    public Uri insert(Uri url, ContentValues initialValues) {
        if (sURLMatcher.match(url) != BOOKMARKS) {
            throw new IllegalArgumentException("Cannot insert into URL: " + url); //$NON-NLS-1$
        }

        // Add the bookmark
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        long rowId = db.insert("bookmarks", null, initialValues); //$NON-NLS-1$
        if (rowId < 0) {
            throw new SQLException("Failed to insert row"); //$NON-NLS-1$
        }
        if (DEBUG) {
            Log.v(TAG, "Added bookmark rowId = " + rowId); //$NON-NLS-1$
        }
        Uri newUrl = ContentUris.withAppendedId(Bookmark.Columns.CONTENT_URI, rowId);

        // Notify changes
        getContext().getContentResolver().notifyChange(newUrl, null);
        return newUrl;
    }

