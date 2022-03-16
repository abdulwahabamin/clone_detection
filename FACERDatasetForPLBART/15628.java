    public void setupFragmentData(){
        mAdapter = new PlaylistAdapter(getActivity(), R.layout.listview_items, null,
                										new String[] {}, new int[] {}, 0);
    	mProjection = new String[] {
                BaseColumns._ID, PlaylistsColumns.NAME
        };
        mSortOrder = Audio.Playlists.DEFAULT_SORT_ORDER;
        mUri = Audio.Playlists.EXTERNAL_CONTENT_URI;
        mFragmentGroupId = 5;
        mType = TYPE_PLAYLIST;
        mTitleColumn = PlaylistsColumns.NAME;         
    }

