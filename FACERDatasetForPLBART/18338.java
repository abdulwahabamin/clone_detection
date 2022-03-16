    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	mApp = (Common) getActivity().getApplicationContext();
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_blacklist_manager, container, false);
        mContext = getActivity().getApplicationContext();
        
        ImageView blacklistImage = (ImageView) rootView.findViewById(R.id.blacklist_image);
        blacklistImage.setImageResource(UIElementsHelper.getIcon(mContext, "manage_blacklists"));
    	
        MANAGER_TYPE = getArguments().getString("MANAGER_TYPE");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        //Get a cursor with a list of blacklisted elements.
        if (MANAGER_TYPE.equals("ARTISTS")) {
            builder.setTitle(R.string.blacklisted_artists);
        	cursor = mApp.getDBAccessHelper().getBlacklistedArtists();
        	
            //Finish the activity if there are no blacklisted elements.
            if (cursor.getCount()==0) {
            	Toast.makeText(getActivity(), R.string.no_blacklisted_items_found, Toast.LENGTH_LONG).show();
            	getActivity().finish();
            } else {
                //Load the cursor data into temporary ArrayLists.
            	for (int i=0; i < cursor.getCount(); i++) {
            		cursor.moveToPosition(i);
            		elementNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)));
            	}
            	
            }

        } else if (MANAGER_TYPE.equals("ALBUMS")) {
            builder.setTitle(R.string.blacklisted_albums);
        	cursor = mApp.getDBAccessHelper().getBlacklistedAlbums();
        	
        	//Finish the activity if there are no blacklisted elements.
            if (cursor.getCount()==0) {
            	Toast.makeText(getActivity(), R.string.no_blacklisted_items_found, Toast.LENGTH_LONG).show();
            	getActivity().finish();
            } else {
                //Load the cursor data into temporary ArrayLists.
            	for (int i=0; i < cursor.getCount(); i++) {
            		cursor.moveToPosition(i);
            		elementNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM)));
            		artistNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)));
            	}
            	
            }
        	
        } else if (MANAGER_TYPE.equals("SONGS")) {
            builder.setTitle(R.string.blacklisted_songs);
        	cursor = mApp.getDBAccessHelper().getAllBlacklistedSongs();
        	
        	//Finish the activity if there are no blacklisted elements.
            if (cursor.getCount()==0) {
            	Toast.makeText(getActivity(), R.string.no_blacklisted_items_found, Toast.LENGTH_LONG).show();
            	getActivity().finish();
            } else {
                //Load the cursor data into temporary ArrayLists.
            	for (int i=0; i < cursor.getCount(); i++) {
            		cursor.moveToPosition(i);
            		elementNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_TITLE)));
            		artistNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)));
            		filePathList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)));
            		songIdsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ID)));
            	}
            	
            }
        	
        } else if (MANAGER_TYPE.equals("PLAYLISTS")) {
            /*builder.setTitle(R.string.blacklisted_playlists);
        	DBAccessHelper playlistsDBHelper = new DBAccessHelper(getActivity());
        	cursor = playlistsDBHelper.getAllBlacklistedPlaylists();
        	
        	//Finish the activity if there are no blacklisted elements.
            if (cursor.getCount()==0) {
            	Toast.makeText(getActivity(), R.string.no_blacklisted_items_found, Toast.LENGTH_LONG).show();
            	getActivity().finish();
            } else {
                //Load the cursor data into temporary ArrayLists.
            	for (int i=0; i < cursor.getCount(); i++) {
            		cursor.moveToPosition(i);
            		elementNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.PLAYLIST_NAME)));
            		artistNameList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.NUMBER_OF_SONGS)));
            		filePathList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.PLAYLIST_FILE_PATH)));
            	}
            	
            }*/
        	
        } else {
        	Toast.makeText(getActivity(), R.string.error_occurred, Toast.LENGTH_LONG).show();
        	getActivity().finish();
        }
        
        
        TextView blacklistManagerInfoText = (TextView) rootView.findViewById(R.id.blacklist_manager_info_text);
        DragSortListView blacklistManagerListView = (DragSortListView) rootView.findViewById(R.id.blacklist_manager_list);
        blacklistManagerListView.setRemoveListener(onRemove);
        
        blacklistManagerInfoText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
        blacklistManagerInfoText.setPaintFlags(blacklistManagerInfoText.getPaintFlags()
        									   | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        blacklistManagerListView.setFastScrollEnabled(true);
        adapter = new BlacklistedElementsAdapter(getActivity(), elementNameList, artistNameList, MANAGER_TYPE);
        blacklistManagerListView.setAdapter(adapter);
        
        return rootView;
        
    }

