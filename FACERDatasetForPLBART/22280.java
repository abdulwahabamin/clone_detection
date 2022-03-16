    /**
     * Given a list of ids, it sorts the results based on the most played results
     *
     * @param ids list
     * @return sorted list - this may be smaller than the list passed in for performance reasons
     */
    public long[] getTopPlayedResultsForList(long[] ids) {
        final int MAX_NUMBER_SONGS_TO_ANALYZE = 250;

        if (ids == null || ids.length == 0) {
            return null;
        }

        HashSet<Long> uniqueIds = new HashSet<Long>(ids.length);

        // create the list of ids to select against
        StringBuilder selection = new StringBuilder();
        selection.append(SongPlayCountColumns.ID);
        selection.append(" IN (");

        // add the first element to handle the separator case for the first element
        uniqueIds.add(ids[0]);
        selection.append(ids[0]);

        for (int i = 1; i < ids.length; i++) {
            // if the new id doesn't exist
            if (uniqueIds.add(ids[i])) {
                // append a separator
                selection.append(",");

                // append the id
                selection.append(ids[i]);

                // for performance reasons, only look at a certain number of songs
                // in case their playlist is ridiculously large
                if (uniqueIds.size() >= MAX_NUMBER_SONGS_TO_ANALYZE) {
                    break;
                }
            }
        }

        // close out the selection
        selection.append(")");

        long[] sortedList = new long[uniqueIds.size()];

        // now query for the songs
        final SQLiteDatabase database = mMusicDatabase.getReadableDatabase();
        Cursor topSongsCursor = null;
        int idx = 0;

        try {
            topSongsCursor = database.query(SongPlayCountColumns.NAME,
                    new String[]{SongPlayCountColumns.ID}, selection.toString(), null, null,
                    null, SongPlayCountColumns.PLAYCOUNTSCORE + " DESC");

            if (topSongsCursor != null && topSongsCursor.moveToFirst()) {
                do {
                    // for each id found, add it to the list and remove it from the unique ids
                    long id = topSongsCursor.getLong(0);
                    sortedList[idx++] = id;
                    uniqueIds.remove(id);
                } while (topSongsCursor.moveToNext());
            }
        } finally {
            if (topSongsCursor != null) {
                topSongsCursor.close();
                topSongsCursor = null;
            }
        }

        // append the remaining items - these are songs that haven't been played recently
        Iterator<Long> iter = uniqueIds.iterator();
        while (iter.hasNext()) {
            sortedList[idx++] = iter.next();
        }

        return sortedList;
    }

