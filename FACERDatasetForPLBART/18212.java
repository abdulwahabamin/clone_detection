    public void reloadPlaylistEntries(ArrayList<Integer> gMusicSongOrder) {
    	/*JSONArray jsonArray = null;
    	try {
			jsonArray = GMusicClientCalls.getPlaylistEntriesWebClient(mContext, mPlaylistId);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Remove all GMusic songs in the current playlist (within the local databse).
		musicLibraryPlaylistsDBHelper.removeGMusicSongsFromPlaylist(mContext, mPlaylistId);
    	
    	//Loop through the playlist's songs array and retrieve each song's metadata.
		WebClientSongsSchema currentPlaylistSong = new WebClientSongsSchema();
    	for (int j=0; j < jsonArray.length(); j++) {
    		try {
    			currentPlaylistSong = currentPlaylistSong.fromJsonObject(jsonArray.getJSONObject(j));
        		//Extract the current playlist song's metadata.
            	String songTrackId = currentPlaylistSong.getId();
            	String playlistEntryId = currentPlaylistSong.getPlaylistEntryId();
            	
            	ContentValues playlistValues = new ContentValues();
            	playlistValues.put(DBAccessHelper.PLAYLIST_NAME, mPlaylistName);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ID, mPlaylistId); 
            	playlistValues.put(DBAccessHelper.PLAYLIST_ART_URL, "");
            	playlistValues.put(DBAccessHelper.PLAYLIST_SOURCE, DBAccessHelper.GMUSIC);
            	playlistValues.put(DBAccessHelper.PLAYLIST_BLACKLIST_STATUS, "FALSE");
            	playlistValues.put(DBAccessHelper.PLAYLIST_SONG_FILE_PATH, songTrackId);
            	playlistValues.put(DBAccessHelper.PLAYLIST_SONG_ENTRY_ID, playlistEntryId);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ORDER, gMusicSongOrder.get(j));
            	
            	//Add all the entries to the database to build the songs library.
            	musicLibraryPlaylistsDBHelper.getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME, 
            												 			   null, 
            												 			   playlistValues);
    		} catch (Exception e) {
    			e.printStackTrace();
    			continue;
    		}
    		
    	}*/
        	
    }

