    /**
     * Purge all internal data whose authority matches the given
     * {@link Predicate}.
     */
    private void purgeByAuthority(Predicate<String> predicate) {
        final SQLiteDatabase db = mHelper.getWritableDatabase();
        final DocumentStack stack = new DocumentStack();

        Cursor cursor = db.query(TABLE_RECENT, null, null, null, null, null, null);
        try {
            while (cursor.moveToNext()) {
                try {
                    final byte[] rawStack = cursor.getBlob(
                            cursor.getColumnIndex(RecentColumns.STACK));
                    DurableUtils.readFromArray(rawStack, stack);

                    if (stack.root != null && predicate.apply(stack.root.authority)) {
                        final String key = getCursorString(cursor, RecentColumns.KEY);
                        db.delete(TABLE_RECENT, RecentColumns.KEY + "=?", new String[] { key });
                    }
                } catch (IOException ignored) {
                }
            }
        } finally {
            IoUtils.closeQuietly(cursor);
        }

        cursor = db.query(TABLE_STATE, new String[] {
                StateColumns.AUTHORITY }, null, null, StateColumns.AUTHORITY, null, null);
        try {
            while (cursor.moveToNext()) {
                final String authority = getCursorString(cursor, StateColumns.AUTHORITY);
                if (predicate.apply(authority)) {
                    db.delete(TABLE_STATE, StateColumns.AUTHORITY + "=?", new String[] {
                            authority });
                    Log.d(TAG, "Purged state for " + authority);
                }
            }
        } finally {
            IoUtils.closeQuietly(cursor);
        }

        cursor = db.query(TABLE_RESUME, null, null, null, null, null, null);
        try {
            while (cursor.moveToNext()) {
                try {
                    final byte[] rawStack = cursor.getBlob(
                            cursor.getColumnIndex(ResumeColumns.STACK));
                    DurableUtils.readFromArray(rawStack, stack);

                    if (stack.root != null && predicate.apply(stack.root.authority)) {
                        final String packageName = getCursorString(
                                cursor, ResumeColumns.PACKAGE_NAME);
                        db.delete(TABLE_RESUME, ResumeColumns.PACKAGE_NAME + "=?",
                                new String[] { packageName });
                    }
                } catch (IOException ignored) {
                }
            }
        } finally {
            IoUtils.closeQuietly(cursor);
        }
    }

