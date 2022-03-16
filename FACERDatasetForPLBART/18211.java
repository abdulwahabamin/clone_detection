    @Override
    protected Boolean doInBackground(String... params) {
    	
		/*//Replace illegal characters in the playlistName.
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
    	
		//If GMusic is enabled, create the playlist on Google's servers first.
    	if (sharedPreferences.getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
        	String playlistId = null;
    		try {
    			playlistId = GMusicClientCalls.createPlaylist(mContext, mPlaylistName);
    			mPlaylistId = playlistId;
    		} catch (IllegalArgumentException e) {
    			e.printStackTrace();
    			return false;
    		} catch (JSONException e) {
    			e.printStackTrace();
    			return false;
    		} catch (Exception e) {
    			e.printStackTrace();
    			return false;
    		}
    		
    	} else {
    		//Create the playlist in Android's MediaStore. mPlaylistId will be assigned in this method.
    		createMediaStorePlaylist(mPlaylistName);
    	}
    	
    	Cursor gMusicCursor = null;
    	ArrayList<Integer> gMusicSongOrder = new ArrayList<Integer>();
    	for (int i=0; i < mCursor.getCount(); i++) {
    		try {
    			mCursor.moveToPosition(i);
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
        														 "LOCAL", 
        														 mPlaylistId,
        														 mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ID)),
        														 new Date().getTime(),
        														 i,
        														 UUID.randomUUID().toString());
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
        		if (GMusicClientCalls.getQueuedMutationsCount()!=0) {
        			GMusicClientCalls.modifyPlaylist(mContext);
        			
        			//Reload the entire playlist.
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
    	}*/
    	
    	return true;
    }

