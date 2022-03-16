    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final int match = MATCHER.match(uri);
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        String selectionCriteria = selection;

        if (match != CACHEDIRECTORY && match != CACHEDIRECTORY_ID)
            throw new IllegalArgumentException("Unknown URI: " + uri);

        if (match == CACHEDIRECTORY_ID) {
            long taskId = DataCache.getId(uri);
            selectionCriteria = DataCache.Columns._ID + " = " + taskId;
            if ((selection != null) && (selection.length() > 0)) {
                selectionCriteria += " AND (" + selection + ")";
            }
        }
        return db.delete(DataCache.TABLE_NAME, selectionCriteria, selectionArgs);
    }

