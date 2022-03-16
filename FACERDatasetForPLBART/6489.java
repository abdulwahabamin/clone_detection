    public RootCursorWrapper(String authority, String rootId, Cursor cursor, int maxCount) {
        mAuthority = authority;
        mRootId = rootId;
        mCursor = cursor;

        final int count = cursor.getCount();
        if (maxCount > 0 && count > maxCount) {
            mCount = maxCount;
        } else {
            mCount = count;
        }

        if (cursor.getColumnIndex(COLUMN_AUTHORITY) != -1
                || cursor.getColumnIndex(COLUMN_ROOT_ID) != -1) {
            throw new IllegalArgumentException("Cursor contains internal columns!");
        }
        final String[] before = cursor.getColumnNames();
        mColumnNames = new String[before.length + 2];
        System.arraycopy(before, 0, mColumnNames, 0, before.length);
        mAuthorityIndex = before.length;
        mRootIdIndex = before.length + 1;
        mColumnNames[mAuthorityIndex] = COLUMN_AUTHORITY;
        mColumnNames[mRootIdIndex] = COLUMN_ROOT_ID;
    }

