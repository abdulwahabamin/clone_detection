    /**
     * Common method for performing a query of the music database, called for
     * both top-level queries and filtering.
     * 
     * @param sync If true, this query should be done synchronously and the
     * resulting cursor returned.  If false, it will be done asynchronously and
     * null returned.
     * @param filterstring If non-null, this is a filter to apply to the query.
     */
    Cursor doQuery(boolean sync, String filterstring) {
        // Cancel any pending queries
        mQueryHandler.cancelOperation(MY_QUERY_TOKEN);
        
        StringBuilder where = new StringBuilder();
        where.append(MediaStore.Audio.Media.TITLE + " != ''");
        
        // Add in the filtering constraints
        String [] keywords = null;
        if (filterstring != null) {
            String [] searchWords = filterstring.split(" ");
            keywords = new String[searchWords.length];
            Collator col = Collator.getInstance();
            col.setStrength(Collator.PRIMARY);
            for (int i = 0; i < searchWords.length; i++) {
                keywords[i] = '%' + MediaStore.Audio.keyFor(searchWords[i]) + '%';
            }
            for (int i = 0; i < searchWords.length; i++) {
                where.append(" AND ");
                where.append(MediaStore.Audio.Media.ARTIST_KEY + "||");
                where.append(MediaStore.Audio.Media.ALBUM_KEY + "||");
                where.append(MediaStore.Audio.Media.TITLE_KEY + " LIKE ?");
            }
        }
        
        // We want to show all audio files, even recordings.  Enforcing the
        // following condition would hide recordings.
        //where.append(" AND " + MediaStore.Audio.Media.IS_MUSIC + "=1");
        
        if (sync) {
            try {
                return getContentResolver().query(mBaseUri, CURSOR_COLS,
                        where.toString(), keywords, mSortOrder);
            } catch (UnsupportedOperationException ex) {
            }
        } else {
            mAdapter.setLoading(true);
            setProgressBarIndeterminateVisibility(true);
            mQueryHandler.startQuery(MY_QUERY_TOKEN, null, mBaseUri, CURSOR_COLS,
                    where.toString(), keywords, mSortOrder);
        }
        return null;
    }

