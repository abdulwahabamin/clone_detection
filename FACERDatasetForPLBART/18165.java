    @Override
    protected Boolean doInBackground(String... params) {
    	
    	/*int which = Integer.parseInt(params[0]);
    	
        //Get a cursor with the list of all user-created playlists.
        DBAccessHelper dbHelper = new DBAccessHelper(mContext);
        final Cursor cursor = dbHelper.getAllUniqueUserPlaylists();
    	
        //Get the file path of the selected playlist.
		cursor.moveToPosition(which);
		String playlistFilePath = cursor.getString(cursor.getColumnIndex(DBAccessHelper.PLAYLIST_FILE_PATH));
		cursor.close();
		
		//Get a list of all songs in the playlist.
		Cursor playlistCursor = dbHelper.getPlaylistByFilePath(playlistFilePath);
		String songFilePath = "";
		
		//Loop through the songs and add them to the EQ settings DB with the current EQ settings.
		if (playlistCursor!=null && playlistCursor.getCount() > 0) {
			
			MediaMetadataRetriever mmdr = new MediaMetadataRetriever();
			songTitle = "";
			songAlbum = "";
			String songArtist = "";
			for (int j=0; j < playlistCursor.getCount(); j++) {
				playlistCursor.moveToPosition(j);
				songFilePath = playlistCursor.getString(playlistCursor.getColumnIndex(DBAccessHelper.PLAYLIST_SONG_FILE_PATH));
				
				try {
					mmdr.setDataSource(songFilePath);
				} catch (Exception e) {
					return false;
				}
				
				songTitle = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
				songAlbum = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
				songArtist = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);	
				
				mEqualizerFragment.saveSettingsToDB(songTitle, songAlbum, songArtist);
				publishProgress();
				
			}
			
		}
    	
		playlistCursor.close();*/
    	return true;
	    
    }

