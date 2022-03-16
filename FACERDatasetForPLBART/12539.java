    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case ID_INDEX:
                tableName = DatabaseHelper.INDEX_TABLE;
                break;
            default:
                throw new RuntimeException("URI not supported!");
        }
        int count = mSQLiteDatabase.delete(tableName, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

