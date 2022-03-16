    @Override
    protected Boolean doInBackground(String... params) {
    	
		//Replace illegal characters in the playlistName.
		if (mPlaylistName.contains("/")) {
			mPlaylistName = mPlaylistName.replace("/", "_");
		}
		
		if (mPlaylistName.contains("\\")) {
			mPlaylistName = mPlaylistName.replace("\\", "_");
		}
    	
    	//Get the cursor with the playlist elements.

    	String playlistFolderPath = sharedPreferences.getString("PLAYLISTS_SAVE_FOLDER", 
    															Environment.getExternalStorageDirectory() + "/Playlists/");
    	String playlistFilePath = playlistFolderPath + mPlaylistName + ".m3u";
    	mCursor = AddPlaylistUtils.getPlaylistElementsCursor(mContext, 
    														 musicLibraryDBHelper, 
    														 sharedPreferences, 
    														 mArtist, 
    														 mAlbum,
    														 mSong, 
    														 mGenre, 
    														 mAlbumArtist,
    														 mAddType);
    	/*
    	Cursor gMusicCursor = null;
    	ArrayList<Integer> gMusicSongOrder = new ArrayList<Integer>();
    	
    	//Fetch the total number of songs in the playlist right now.
    	int currentSongCount = musicLibraryPlaylistsDBHelper.getPlaylistSongCount(null, mPlaylistId);
    	
    	//Loop through the number of GMusic songs in the playlist and add their order to gMusicSongOrder.
    	gMusicCursor = musicLibraryPlaylistsDBHelper.getGMusicSongsInPlaylist(null, mPlaylistId);
    	while (gMusicCursor.moveToNext()) {
    		if (gMusicCursor.getString(gMusicCursor.getColumnIndex(DBAccessHelper.PLAYLIST_SOURCE))
    						.equals(DBAccessHelper.GMUSIC)) {
    			int songOrder = gMusicCursor.getInt(gMusicCursor.getColumnIndex(DBAccessHelper.PLAYLIST_ORDER));
    			gMusicSongOrder.add(songOrder);
    		}
    		
    	}
    	
    	gMusicCursor.close();
    	gMusicCursor = null;
    	for (int i=currentSongCount; i < (mCursor.getCount() + currentSongCount); i++) {
    		try {
    			mCursor.moveToPosition(i - currentSongCount);
    			String songSource = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_SOURCE));
    			
    			 This if/else block will handle the different operations that need to be 
    			 * done/ommitted for each different song type (Google Play Music vs local
    			 * song file).
    			 
    			String clientId = "";
    			if (songSource.equals(DBAccessHelper.GMUSIC)) {
    				
    				//Retrieve the clientId of the current song from GMusic's content mApp.
        	    	Uri googlePlayMusicContentProviderUri = Uri.parse("content://com.google.android.music.MusicContent/audio");
        	    	String[] projection = { "SourceId", "ClientId AS client_id" };
        			
        			String songId = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ID));
        			String selection = "SourceId=" + "'" + songId + "'";
        	    	gMusicCursor = mContext.getContentResolver().query(googlePlayMusicContentProviderUri, projection, selection, null, null);
        	    	gMusicCursor.moveToFirst();
        	    	clientId = gMusicCursor.getString(1);
        			
        	    	//Populate the mutations JSONArray.
        			JSONObject createObject = new JSONObject();

        			createObject.put("lastModifiedTimestamp", "0");
        			createObject.put("playlistId", mPlaylistId);
        			createObject.put("creationTimestamp", "-1");
        			createObject.put("type", "USER_GENERATED");
        			createObject.put("source", 1);
        			createObject.put("deleted", false);
        			createObject.put("trackId", songId);
        			createObject.put("clientId", clientId);
        			
        			//Add the request to the JSONArray queue that will update Google's servers.
        	    	GMusicClientCalls.putCreatePlaylistEntryRequest(createObject);	
        	    	gMusicSongOrder.add(i);
        			
    			} else {

    				//Add the song to Android's MediaStore database.
    				String artist = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
    				String album = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM));
    				String title = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_TITLE));
    				
    				try {
    					long audioId = getSongAudioId(artist, album, title);
    					if (audioId!=-1) {
    						addSongToPlaylist(mContext.getContentResolver(), audioId, Long.parseLong(mPlaylistId));
    					}
        				
    				} catch (Exception e) {
    					//Just fail silently if this song can't be inserted into the playlist.
    					e.printStackTrace();
    				}
    				
        			//Add the song to the playlists database.
        			musicLibraryPlaylistsDBHelper.addNewPlaylist(mPlaylistName, 
        														 playlistFilePath, 
        														 playlistFolderPath, 
        														 mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)), 
        														 DBAccessHelper.GMUSIC, 
        														 mPlaylistId,
        														 mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ID)),
        														 new Date().getTime(),
        														 i,
        														 clientId);
    				
    			}
    		
    		} catch (Exception e) {
    			e.printStackTrace();
    			continue;
    		}
    		
    	}
    	
    	//Show a confirmation toast message.
    	publishProgress(new Integer[] {0});
    	
    	//Send the HTTP request that will update Google's servers.
    	if (sharedPreferences.getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
        	try {
        		if (GMusicClientCalls.getQueuedMutationsCount() > 0) {
        			GMusicClientCalls.modifyPlaylist(mContext);
        			
        			//Refetch the entire playlist that has just been modified.
        			reloadPlaylistEntries(gMusicSongOrder);
        		}
    			
    		} catch (IllegalArgumentException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (JSONException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
    	}
		
    	if (gMusicCursor!=null) {
    		gMusicCursor.close();
    		gMusicCursor = null;
    	}
    	
    	return true;
    }
    
    public void reloadPlaylistEntries(ArrayList<Integer> gMusicSongOrder) {
    	JSONArray jsonArray = null;
    	try {
			jsonArray = GMusicClientCalls.getPlaylistEntriesWebClient(mContext, mPlaylistId);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Remove the current GMusic entries within the playlist.
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
    		
    	}
    	*/
    	
    	return null;
        	
    }

