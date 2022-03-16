	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		mContext = getActivity().getApplicationContext();
		
		//Retrieve the arguments.
		ADD_TYPE = getArguments().getString("ADD_TYPE");
		
		if (ADD_TYPE.equals("ARTIST")) {
			ARTIST = getArguments().getString("ARTIST");
		} else if (ADD_TYPE.equals("ALBUM_ARTIST")) {
			ALBUM_ARTIST = getArguments().getString("ALBUM_ARTIST");
		} else if (ADD_TYPE.equals("ALBUM")) {
			ARTIST = getArguments().getString("ARTIST");
			ALBUM = getArguments().getString("ALBUM");
		} else if (ADD_TYPE.equals("SONG")) {
			ARTIST = getArguments().getString("ARTIST");
			ALBUM = getArguments().getString("ALBUM");
			SONG = getArguments().getString("SONG");
		} else if (ADD_TYPE.equals("GENRE")) {
			GENRE = getArguments().getString("GENRE");
		} else if (ADD_TYPE.equals("ALBUM_BY_ALBUM_ARTIST")) {
			ALBUM = getArguments().getString("ALBUM");
			ALBUM_ARTIST = getArguments().getString("ALBUM_ARTIST");
		}
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String columns[] = { DBAccessHelper.PLAYLIST_NAME, DBAccessHelper._ID,
        					 DBAccessHelper.PLAYLIST_FILE_PATH, DBAccessHelper.PLAYLIST_SOURCE,
        					 DBAccessHelper.PLAYLIST_ID };
        MatrixCursor matrixCursor = new MatrixCursor(columns);
        matrixCursor.addRow(new String[] { getActivity().getResources().getString(R.string.new_playlist), "0", "0", "0", "0" });
        
        DBAccessHelper playlistsDBHelper = new DBAccessHelper(getActivity()
        																				    .getApplicationContext());
        Cursor userPlaylistsCursor = playlistsDBHelper.getAllSongsInAlbum(null, null);
        final MergeCursor mergeCursor = new MergeCursor(new Cursor[] { matrixCursor, userPlaylistsCursor });
        
        //Set the dialog title.
        builder.setTitle(R.string.add_to_playlist);
        builder.setCursor(mergeCursor, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Index 0 is the dummy playlist that will open the "New Playlist" dialog.
				if (which==0) {
					showNewPlaylistDialog();
				} else {
					mergeCursor.moveToPosition(which);
					String playlistName = mergeCursor.getString(mergeCursor.getColumnIndex(DBAccessHelper.PLAYLIST_NAME));
					String playlistId = mergeCursor.getString(mergeCursor.getColumnIndex(DBAccessHelper.PLAYLIST_ID));

					AsyncAddSongsToPlaylistTask task = new AsyncAddSongsToPlaylistTask(mContext,
																					   playlistName,
																					   playlistId,
																					   ARTIST,
																					   ALBUM,
																					   SONG,
																					   GENRE,
																					   ALBUM_ARTIST, 
																					   ADD_TYPE);
					task.execute();
					
				}
				
			}
        	
        }, DBAccessHelper.PLAYLIST_NAME);

        return builder.create();
    }

