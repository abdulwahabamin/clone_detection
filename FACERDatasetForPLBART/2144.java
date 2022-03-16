    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final int code = MATCHER.match(uri);
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        switch (code) {
            case CACHEDIRECTORY:
                queryBuilder.setTables(DataCache.TABLE_NAME);
                break;
            case CACHEDIRECTORY_ID:
                queryBuilder.setTables(DataCache.TABLE_NAME);
                long taskId = DataCache.getId(uri);
                queryBuilder.appendWhere(DataCache.Columns._ID + " = " + taskId);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        return queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
    }

