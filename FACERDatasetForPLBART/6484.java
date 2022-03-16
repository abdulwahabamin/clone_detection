    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase db = mHelper.getWritableDatabase();
        final ContentValues key = new ContentValues();
        switch (sMatcher.match(uri)) {
            case URI_RECENT:
                values.put(RecentColumns.TIMESTAMP, System.currentTimeMillis());
                db.insert(TABLE_RECENT, null, values);
                final long cutoff = System.currentTimeMillis() - MAX_HISTORY_IN_MILLIS;
                db.delete(TABLE_RECENT, RecentColumns.TIMESTAMP + "<" + cutoff, null);
                return uri;
            case URI_STATE:
                final String authority = uri.getPathSegments().get(1);
                final String rootId = uri.getPathSegments().get(2);
                final String documentId = uri.getPathSegments().get(3);

                key.put(StateColumns.AUTHORITY, authority);
                key.put(StateColumns.ROOT_ID, rootId);
                key.put(StateColumns.DOCUMENT_ID, documentId);

                // Ensure that row exists, then update with changed values
                db.insertWithOnConflict(TABLE_STATE, null, key, SQLiteDatabase.CONFLICT_IGNORE);
                db.update(TABLE_STATE, values, StateColumns.AUTHORITY + "=? AND "
                        + StateColumns.ROOT_ID + "=? AND " + StateColumns.DOCUMENT_ID + "=?",
                        new String[] { authority, rootId, documentId });

                return uri;
            case URI_RESUME:
                values.put(ResumeColumns.TIMESTAMP, System.currentTimeMillis());

                final String packageName = uri.getPathSegments().get(1);
                key.put(ResumeColumns.PACKAGE_NAME, packageName);

                // Ensure that row exists, then update with changed values
                db.insertWithOnConflict(TABLE_RESUME, null, key, SQLiteDatabase.CONFLICT_IGNORE);
                db.update(TABLE_RESUME, values, ResumeColumns.PACKAGE_NAME + "=?",
                        new String[] { packageName });
                return uri;
            default:
                throw new UnsupportedOperationException("Unsupported Uri " + uri);
        }
    }

