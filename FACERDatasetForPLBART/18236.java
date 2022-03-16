    /*************************************************************************************
     * Retrieves the user's playlists and their contents using the MobileClient protocol.
     * 
     * @deprecated The entryIds that we're fetching from the MobileClient protocol seem 
     * to be broken. They don't work with reordering playlist songs. I'll fix this if/when 
     * I have time. Until then, I'm gonna use getPlaylistsWebClient().
     *************************************************************************************/
    @SuppressWarnings("static-access")
	private void getPlaylistsMobileClient() {
    	
/*    	//Clear out all the current Google Play Music playlists in the database.
    	DBAccessHelper musicLibraryPlaylistsDBHelper = new DBAccessHelper(mContext);
    	musicLibraryPlaylistsDBHelper.deleteAllGooglePlayMusicPlaylists();
    	
    	//Insert the songs and their metadata into Jams' local database.
    	 To improve database insertion performance, we'll use a single transaction 
    	 * for the entire operation. SQLite journals each database insertion and 
    	 * creates a new transaction by default. We'll override this functionality 
    	 * and create a single transaction for all the database record insertions. 
    	 * In theory, this should reduce NAND memory overhead times and result in 
    	 * a 2x to 5x performance increase.
    	 
    	try {
    		//Open a connection to the database.
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().beginTransaction();
    		
    		*//*****************************************************************************
    		 * The following calls are based on the MobileClient endpoints. Unfortunately, 
    		 * we can't get the correct entryIds for each song with these calls, so we'll 
    		 * have to revert to using the WebClient calls.
    		 *****************************************************************************//*
    		//Instantiate the GMusic API and retrieve an array of all playlists.
        	GMusicClientCalls gMusicClientCalls = GMusicClientCalls.getInstance(mContext);
        	try {
    			playlistsJSONArray = gMusicClientCalls.getUserPlaylistsMobileClient(mContext);
    		} catch (JSONException e) {
    			e.printStackTrace();
    		}
        	
        	//Retrieve an array of all song entries within every playlist.
        	try {
        		playlistEntriesJSONArray = gMusicClientCalls.getPlaylistEntriesMobileClient(mContext);
        	} catch (JSONException e) {
        		e.printStackTrace();
        	}
        	
        	 Now that we have a JSONArray with all the unique playlists, it's time to 
        	 * index the playlistIds and their name within the array. This will 
        	 * allow us to efficiently figure out the name of the playlist without 
        	 * going through the entire original array over and over again.
        	 
        	MobileClientPlaylistsSchema currentPlaylist = new MobileClientPlaylistsSchema();
        	for (int k=0; k < playlistsJSONArray.length(); k++) {
        		currentPlaylist = currentPlaylist.fromJsonObject(playlistsJSONArray.getJSONObject(k));
        		if (!playlistIdsNameMap.containsKey(currentPlaylist.getPlaylistId())) {
        			playlistIdsNameMap.put(currentPlaylist.getPlaylistId(), currentPlaylist.getName());
        		}
        		
        	}
        	

    		//Avoid "Divide by zero" errors.
    		int scanningPlaylistsIncrement;
    		if (playlistEntriesJSONArray.length()!=0) {
    			scanningPlaylistsIncrement = 100000/playlistEntriesJSONArray.length();
    		} else {
    			scanningPlaylistsIncrement = 100000/1;
    		}
    		currentTask = mContext.getResources().getString(R.string.syncing_with_google_play_music);
    		
    		MobileClientPlaylistEntriesSchema currentPlaylistEntry = new MobileClientPlaylistEntriesSchema();
    		for (int i=0; i < playlistEntriesJSONArray.length(); i++) {
            	currentProgressValue = currentProgressValue + scanningPlaylistsIncrement;
            	publishProgress();
            	
            	//Get the playlist's metadata.
            	currentPlaylistEntry = currentPlaylistEntry.fromJsonObject(playlistEntriesJSONArray.getJSONObject(i));
            	String playlistName = playlistIdsNameMap.get(currentPlaylistEntry.getPlaylistId());
            	String playlistId = currentPlaylistEntry.getPlaylistId();
            	String id = currentPlaylistEntry.getId();
            	String clientId = currentPlaylistEntry.getClientId();
            	String trackId = currentPlaylistEntry.getTrackId();
            	
            	 GMusic's backend server uses horribly misleading JSON key names. 
            	 * Each playlist entry has an entryId. When reordering songs, this 
            	 * entryId is actually the clientId of the song. The songId matches 
            	 * trackId. The "id" key in the JSON response is seemingly not 
            	 * used for anything in particular.
            	 
            	ContentValues playlistValues = new ContentValues();
            	playlistValues.put(DBAccessHelper.PLAYLIST_NAME, playlistName);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ID, playlistId);
            	playlistValues.put(DBAccessHelper.PLAYLIST_ART_URL, "");
            	playlistValues.put(DBAccessHelper.PLAYLIST_SOURCE, DBAccessHelper.GMUSIC);
            	playlistValues.put(DBAccessHelper.PLAYLIST_SONG_ID, id);
            	playlistValues.put(DBAccessHelper.PLAYLIST_BLACKLIST_STATUS, "FALSE");
            	playlistValues.put(DBAccessHelper.PLAYLIST_ORDER, i);
            	playlistValues.put(DBAccessHelper.PLAYLIST_SONG_ENTRY_ID, clientId);
            	
            	Log.e("DEBUG", "--------------------PLAYLIST ENTRY--------------------");
            	Log.e("DEBUG", "playlistName: " + playlistName);
            	Log.e("DEBUG", "playlistId: " + playlistId);
            	Log.e("DEBUG", "id: " + id);
            	Log.e("DEBUG", "clientId (entryId): " + clientId);
            	Log.e("DEBUG", "trackId: " + trackId);
            	
            	 We're gonna have to save the playlist's song IDs into the PLAYLIST_SONG_FILE_PATH 
            	 * field. Google Play Music playlist songs don't have a file path, but we're using a 
            	 * JOIN in PlaylistsFlippedFragment that relies on this field, so we'll need to use the 
            	 * "songId" param as a placeholder instead. The "trackId" key corresponds to "songId"
            	 * in the songs table.
            	 
            	playlistValues.put(DBAccessHelper.PLAYLIST_SONG_FILE_PATH, trackId);
            	
            	//Add all the entries to the database to build the songs library.
            	musicLibraryPlaylistsDBHelper.getWritableDatabase().insert(DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME, 
            												 			   null, 
            												 			   playlistValues);
            	
            }
    		
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().setTransactionSuccessful();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		//Seal off all connections to the database.
    		musicLibraryPlaylistsDBHelper.getWritableDatabase().endTransaction();
    		musicLibraryPlaylistsDBHelper.close();
    	}*/
    	
    }

