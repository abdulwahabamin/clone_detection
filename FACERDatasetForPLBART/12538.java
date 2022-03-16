    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case ID_INDEX:
                tableName = DatabaseHelper.INDEX_TABLE;
                break;
            default:
                throw new RuntimeException("URI not supported!");
        }
        long rowId = mSQLiteDatabase.insert(tableName, null, contentValues);
        if (rowId > 0) {
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLException("Failed to add new record");
    }

