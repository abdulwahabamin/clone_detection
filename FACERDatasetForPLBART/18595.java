	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		parentActivity = getActivity();
		dialog = this;

		//Retrieve the arguments.
		final String PLAYLIST_NAME = getArguments().getString("PLAYLIST_NAME");
		final String PLAYLIST_FILE_PATH = getArguments().getString("PLAYLIST_FILE_PATH");
		final String PLAYLIST_FOLDER_PATH = getArguments().getString("PLAYLIST_FOLDER_PATH");
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        dialogView = parentActivity.getLayoutInflater().inflate(R.layout.rename_playlist_dialog_layout, null);
        
        playlistInfo = (TextView) dialogView.findViewById(R.id.rename_playlist_info);
        playlistInfo.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
        playlistInfo.setPaintFlags(playlistInfo.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        playlistNameField = (EditText) dialogView.findViewById(R.id.rename_playlist_text_field);
        playlistNameField.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
        playlistNameField.setPaintFlags(playlistNameField.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        playlistNameField.setText(PLAYLIST_NAME);
        
        //Set the dialog title.
        builder.setTitle(R.string.rename_playlist);
        builder.setView(dialogView);
        builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        builder.setPositiveButton(R.string.done, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				//Create a File that points to the playlist on the filesystem.
				File file = new File(PLAYLIST_FILE_PATH);
				
				//Retrieve the name and file path for the playlist.
				String playlistName = playlistNameField.getText().toString();
				
				//Replace illegal characters in the playlistName.
				if (playlistName.contains("/")) {
					playlistName = playlistName.replace("/", "_");
				}
				
				if (playlistName.contains("\\")) {
					playlistName = playlistName.replace("\\", "_");
				}
				
				//Create another File that points to the renamed playlist file.
				File newFile = new File(PLAYLIST_FOLDER_PATH + "/" + playlistName + ".m3u");
				file.renameTo(newFile);

				/*//Update the database with the new file path and playlist name.
				DBAccessHelper playlistsDBHelper = new DBAccessHelper(parentActivity);
				playlistsDBHelper.renamePlaylist(PLAYLIST_FILE_PATH, playlistName, newFile.getAbsolutePath());
				
				//Delete any instances of the old DB entries.
				playlistsDBHelper.deleteSpecificPlaylist(PLAYLIST_NAME, PLAYLIST_FILE_PATH);*/
				
				Toast.makeText(parentActivity, R.string.playlist_renamed, Toast.LENGTH_SHORT).show();
				
				//Refresh the playlists list view.
				//PlaylistsFragment playlistsFragment = new PlaylistsFragment();
				//playlistsFragment.refreshPlaylists();
				
				//playlistsDBHelper.close();
				dialog.dismiss();
			}
        	
        });

        return builder.create();
    }

