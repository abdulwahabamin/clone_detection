    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case ID_INDEX:
                tableName = DatabaseHelper.INDEX_TABLE;
                break;
            default:
                throw new RuntimeException("URI not supported!");
        }

        Cursor cursor = mSQLiteDatabase.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

