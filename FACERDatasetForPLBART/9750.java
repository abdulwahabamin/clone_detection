    /**
     * {@inheritDoc}
     */
    @Override
    public int update(Uri url, ContentValues values, String where, String[] whereArgs) {
        int count;
        long rowId = 0;
        int match = sURLMatcher.match(url);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        switch (match) {
            case BOOKMARKS_ID: {
                String segment = url.getPathSegments().get(1);
                rowId = Long.parseLong(segment);
                count = db.update(
                        "bookmarks", values, "_id=" + rowId, null); //$NON-NLS-1$ //$NON-NLS-2$
                break;
            }
            default: {
                throw new UnsupportedOperationException(
                        "Cannot update URL: " + url); //$NON-NLS-1$
            }
        }
        if (DEBUG) {
            Log.v(TAG,
                  "*** notifyChange() rowId: " + //$NON-NLS-1$
                  rowId + " url " + url); //$NON-NLS-1$
        }
        getContext().getContentResolver().notifyChange(url, null);
        return count;
    }

