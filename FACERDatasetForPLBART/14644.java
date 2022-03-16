    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    	 String[] projection = new String[] {
                 BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST
         };
         StringBuilder where = new StringBuilder();
         String sortOrder = MediaColumns.DATE_ADDED + " DESC";
         Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
         int X = MusicUtils.getIntPref(getActivity(), NUMWEEKS, 5) * 3600 * 24 * 7;
         where = new StringBuilder();
         where.append(MediaColumns.TITLE + " != ''");
         where.append(" AND " + AudioColumns.IS_MUSIC + "=1");
         where.append(" AND " + MediaColumns.DATE_ADDED + ">"
                 + (System.currentTimeMillis() / 1000 - X));
         return new AddIdCursorLoader(getActivity(), uri, projection, where.toString(), null, sortOrder);
        
        //return new RecentlyAddedLoader(getActivity());
    }

