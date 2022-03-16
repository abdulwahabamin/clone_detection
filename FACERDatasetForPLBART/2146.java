    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = MATCHER.match(uri);
        final SQLiteDatabase db;
        Uri returnUri;
        long recordId;
        switch (match) {
            case CACHEDIRECTORY:
                db = mOpenHelper.getWritableDatabase();
                recordId = db.insertWithOnConflict(DataCache.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                if (recordId > 0) {
                    returnUri = DataCache.buildUri(recordId);
                } else {
                    throw new android.database.SQLException("Failed to insert: " + uri.toString());
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return returnUri;
    }

