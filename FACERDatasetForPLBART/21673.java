    /**
     * This function populates mOrderedPositions with the cursor positions in the order based
     * on the order passed in
     *
     * @param order     the target order of the internal cursor
     * @param extraData Extra data we want to add to the cursor
     * @return returns the ids that aren't found in the underlying cursor
     */
    private ArrayList<Long> buildCursorPositionMapping(final long[] order,
                                                       final String columnName, final List<? extends Object> extraData) {
        ArrayList<Long> missingIds = new ArrayList<Long>();

        mOrderedPositions = new ArrayList<Integer>(mCursor.getCount());
        mExtraData = new ArrayList<Object>();

        mMapCursorPositions = new HashMap<Long, Integer>(mCursor.getCount());
        final int idPosition = mCursor.getColumnIndex(columnName);

        if (mCursor.moveToFirst()) {
            // first figure out where each of the ids are in the cursor
            do {
                mMapCursorPositions.put(mCursor.getLong(idPosition), mCursor.getPosition());
            } while (mCursor.moveToNext());

            // now create the ordered positions to map to the internal cursor given the
            // external sort order
            for (int i = 0; order != null && i < order.length; i++) {
                final long id = order[i];
                if (mMapCursorPositions.containsKey(id)) {
                    mOrderedPositions.add(mMapCursorPositions.get(id));
                    mMapCursorPositions.remove(id);
                    if (extraData != null) {
                        mExtraData.add(extraData.get(i));
                    }
                } else {
                    missingIds.add(id);
                }
            }

            mCursor.moveToFirst();
        }

        return missingIds;
    }

