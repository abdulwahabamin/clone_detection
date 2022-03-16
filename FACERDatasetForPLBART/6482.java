    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) {
        final SQLiteDatabase db = mHelper.getReadableDatabase();
        switch (sMatcher.match(uri)) {
            case URI_RECENT:
                final long cutoff = System.currentTimeMillis() - MAX_HISTORY_IN_MILLIS;
                return db.query(TABLE_RECENT, projection, RecentColumns.TIMESTAMP + ">" + cutoff,
                        null, null, null, sortOrder);
            case URI_STATE:
                final String authority = uri.getPathSegments().get(1);
                final String rootId = uri.getPathSegments().get(2);
                final String documentId = uri.getPathSegments().get(3);
                return db.query(TABLE_STATE, projection, StateColumns.AUTHORITY + "=? AND "
                        + StateColumns.ROOT_ID + "=? AND " + StateColumns.DOCUMENT_ID + "=?",
                        new String[] { authority, rootId, documentId }, null, null, sortOrder);
            case URI_RESUME:
                final String packageName = uri.getPathSegments().get(1);
                return db.query(TABLE_RESUME, projection, ResumeColumns.PACKAGE_NAME + "=?",
                        new String[] { packageName }, null, null, sortOrder);
            default:
                throw new UnsupportedOperationException("Unsupported Uri " + uri);
        }
    }

