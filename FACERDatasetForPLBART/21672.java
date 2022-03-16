    /**
     * @param cursor     to wrap
     * @param order      the list of unique ids in sorted order to display
     * @param columnName the column name of the id to look up in the internal cursor
     */
    public SortedCursor(final Cursor cursor, final long[] order, final String columnName,
                        final List<? extends Object> extraData) {
        if (cursor == null) {
            throw new IllegalArgumentException("Non-null cursor is needed");
        }

        mCursor = cursor;
        mMissingIds = buildCursorPositionMapping(order, columnName, extraData);
    }

