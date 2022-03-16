    public void setupFragmentData(){
        mAdapter = new SonglistAdapter(getActivity(), R.layout.listview_items, null,
                										new String[] {}, new int[] {}, 0);
    	mProjection = new String[] {
                BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST
        };
        StringBuilder where = new StringBuilder();
        where.append(AudioColumns.IS_MUSIC + "=1").append(" AND " + MediaColumns.TITLE + " != ''");
        mWhere = where.toString();
        mSortOrder = Audio.Media.DEFAULT_SORT_ORDER;
        mUri = Audio.Media.EXTERNAL_CONTENT_URI;
        mFragmentGroupId = 3;
        mType = TYPE_SONG;
        mTitleColumn = MediaColumns.TITLE;         
        View shuffle_temp = View.inflate(getActivity(), R.layout.shuffle_all, null);
        mListView.addHeaderView(shuffle_temp);        
    	RelativeLayout  shuffle = (RelativeLayout)shuffle_temp.findViewById(R.id.shuffle_wrapper);
    	shuffle.setVisibility(View.VISIBLE);
    	shuffle.setOnClickListener(new RelativeLayout.OnClickListener() {  
            public void onClick(View v)
            {
                Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
                String[] projection = new String[] {
                    BaseColumns._ID
                };
                String selection = AudioColumns.IS_MUSIC + "=1";
                String sortOrder = "RANDOM()";
                Cursor cursor = MusicUtils.query(getActivity(), uri, projection, selection, null, sortOrder);
                if (cursor != null) {
                    MusicUtils.shuffleAll(getActivity(), cursor);
                    cursor.close();
                    cursor = null;
                }
            }
         });
    }

