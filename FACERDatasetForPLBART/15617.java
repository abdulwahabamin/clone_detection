    public void setupFragmentData(){
        mAdapter = new GenreAdapter(getActivity(), R.layout.listview_items, null,
                new String[] {}, new int[] {}, 0);
    	mProjection = new String[] {
                Audio.Genres._ID, Audio.Genres.NAME
        };        
        mSortOrder = Audio.Genres.DEFAULT_SORT_ORDER;
        mUri = Audio.Genres.EXTERNAL_CONTENT_URI;
        mFragmentGroupId = 4;
        mType = TYPE_GENRE;
        mTitleColumn = Audio.Genres.NAME;         
    }

