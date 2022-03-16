    public FilteringCursorWrapper(
            Cursor cursor, String[] acceptMimes, String[] rejectMimes, long rejectBefore) {
        mCursor = cursor;

        final int count = cursor.getCount();
        mPosition = new int[count];

        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && mCount < count) {
            final String mimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
            final long lastModified = getCursorLong(cursor, Document.COLUMN_LAST_MODIFIED);
            if (rejectMimes != null && MimePredicate.mimeMatches(rejectMimes, mimeType)) {
                continue;
            }
            if (lastModified < rejectBefore) {
                continue;
            }
            if (MimePredicate.mimeMatches(acceptMimes, mimeType)) {
                mPosition[mCount++] = cursor.getPosition();
            }
        }

        Log.d(TAG, "Before filtering " + cursor.getCount() + ", after " + mCount);
    }

