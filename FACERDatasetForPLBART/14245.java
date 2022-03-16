    /**
     * Create a Search Chooser
     */
    public static void doSearch(Context mContext, Cursor mCursor, int index) {
        CharSequence title = null;
        Intent i = new Intent();
        i.setAction(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String query = mCursor.getString(index);
        title = "";
        i.putExtra("", query);
        title = title + " " + query;
        title = "Search " + title;
        i.putExtra(SearchManager.QUERY, query);
        mContext.startActivity(Intent.createChooser(i, title));
    }

