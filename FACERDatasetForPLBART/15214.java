    /**
     * Create a Search Chooser
     */
    public static void doSearch(Context mContext, Cursor mCursor, String Type) {
        CharSequence title = null;
        Intent i = new Intent();
        i.setAction(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String query = "";

    	if ( Type == TYPE_ALBUM ){
    		query = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ALBUM));
    	}
    	else if( Type == TYPE_ARTIST ){
    		query = mCursor.getString(mCursor.getColumnIndexOrThrow(ArtistColumns.ARTIST));
    	}
    	else if( Type == TYPE_GENRE ||  Type == TYPE_PLAYLIST ||  Type == TYPE_SONG ){
    		query = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaColumns.TITLE));
    	}
        title = "";
        i.putExtra("", query);
        title = title + " " + query;
        title = "Search " + title;
        i.putExtra(SearchManager.QUERY, query);
        mContext.startActivity(Intent.createChooser(i, title));
    }

