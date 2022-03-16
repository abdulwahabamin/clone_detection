	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		mApp = (Common) getActivity().getApplicationContext();
		
		final BlacklistedElementsDialog dialog = this;
		MANAGER_TYPE = getArguments().getString("MANAGER_TYPE");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        //Get a cursor with a list of blacklisted elements.
        if (MANAGER_TYPE.equals("ARTISTS")) {
            builder.setTitle(R.string.blacklisted_artists);
        	cursor = mApp.getDBAccessHelper().getBlacklistedArtists();

        } else if (MANAGER_TYPE.equals("ALBUMS")) {
            builder.setTitle(R.string.blacklisted_albums);
        	cursor = mApp.getDBAccessHelper().getBlacklistedAlbums();
        	
        } else if (MANAGER_TYPE.equals("SONGS")) {
            builder.setTitle(R.string.blacklisted_songs);
        	cursor = mApp.getDBAccessHelper().getAllBlacklistedSongs();
        	
        } else if (MANAGER_TYPE.equals("PLAYLISTS")) {
            builder.setTitle(R.string.blacklisted_playlists);
        	/*DBAccessHelper playlistsDBHelper = new DBAccessHelper(getActivity());
        	cursor = playlistsDBHelper.getAllBlacklistedPlaylists();*/
        	
        } else {
        	Toast.makeText(getActivity(), R.string.error_occurred, Toast.LENGTH_LONG).show();
        	return builder.create();
        }
        
        //Dismiss the dialog if there are no blacklisted elements.
        if (cursor.getCount()==0) {
        	Toast.makeText(getActivity(), R.string.no_blacklisted_items_found, Toast.LENGTH_LONG).show();
        	return builder.create();
        }

        //Loop through checkboxStatuses and insert "TRUE" at every position by default.
        for (int i=0; i < cursor.getCount(); i++) {
        	checkboxStatuses.add(true);
        }

        View rootView = this.getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_blacklist_manager, null);
        TextView blacklistManagerInfoText = (TextView) rootView.findViewById(R.id.blacklist_manager_info_text);
        ListView blacklistManagerListView = (ListView) rootView.findViewById(R.id.blacklist_manager_list);
        
        blacklistManagerInfoText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
        blacklistManagerInfoText.setPaintFlags(blacklistManagerInfoText.getPaintFlags()
        									   | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        blacklistManagerListView.setFastScrollEnabled(true);
        BlacklistedElementsAdapter adapter = new BlacklistedElementsAdapter(getActivity(), cursor);
        blacklistManagerListView.setAdapter(adapter);
        
        builder.setView(rootView);
        builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        builder.setPositiveButton(R.string.done, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Loop through checkboxStatuses and unblacklist the elements that have been unchecked.
				for (int i=0; i < checkboxStatuses.size(); i++) {
					
					cursor.moveToPosition(i);
					if (checkboxStatuses.get(i)==true) {
						//The item is still blacklisted.
						continue;
					} else {
						//The item has been unblacklisted.
				        if (MANAGER_TYPE.equals("ARTISTS")) {
				        	mApp.getDBAccessHelper().setBlacklistForArtist(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)), false);
				        	
				        } else if (MANAGER_TYPE.equals("ALBUMS")) {
				        	mApp.getDBAccessHelper().setBlacklistForAlbum(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM)), 
				        										cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)), 
				        										false);

				        } else if (MANAGER_TYPE.equals("SONGS")) {
				        	mApp.getDBAccessHelper().setBlacklistForSong(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)), false);

				        } else if (MANAGER_TYPE.equals("PLAYLISTS")) {
				        	/*DBAccessHelper playlistsDBHelper = new DBAccessHelper(getActivity());
				        	playlistsDBHelper.unBlacklistPlaylist(cursor.getString(cursor.getColumnIndex(DBAccessHelper.PLAYLIST_BLACKLIST_STATUS)));*/

				        }
						
					}
					
				}
				
				dialog.dismiss();
				
			}
        	
        });
        
        return builder.create();
    }

