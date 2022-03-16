    public void setupFragmentData(){
        mAdapter =new ArtistAlbumAdapter(getActivity(), R.layout.listview_items, null,
                									new String[] {}, new int[] {}, 0);
    	mProjection = new String[] {
                BaseColumns._ID, AlbumColumns.ALBUM, AlbumColumns.NUMBER_OF_SONGS,
                AlbumColumns.ARTIST
        };
        mSortOrder =  Audio.Albums.DEFAULT_SORT_ORDER;
        long artistId = getArguments().getLong((BaseColumns._ID));
        mUri = Audio.Artists.Albums.getContentUri(EXTERNAL, artistId);
        mFragmentGroupId = 7;
        mType = TYPE_ALBUM;     
    }

