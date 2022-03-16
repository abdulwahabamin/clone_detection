	@Override
    protected Boolean doInBackground(String... params) {
		
		//Iterate through the cursor and download/cache the requested songs.
		boolean getAllPinnedTracks = false;
		if (mApp.getPinnedSongsCursor()==null) {
			//The user asked to get all pinned songs from the official GMusic app.
			getAllPinnedTracks = true;
			
			//Check to make sure that the official GMusic app exists.
			PackageManager pm = mContext.getPackageManager();
	    	boolean installed = false;
	    	try {
				pm.getPackageInfo("com.google.android.music", PackageManager.GET_ACTIVITIES);
				installed = true;
			} catch (NameNotFoundException e1) {
				//The app isn't installed.
				installed = false;
			}
	    	
	    	if (installed==false) {
	    		//The app isn't installed. Notify the user.
	    		publishProgress(new Integer[] {2});
	    		return false;
	    	}
	    	
	    	//Query GMusic's content mApp for pinned songs.
	    	Uri googlePlayMusicContentProviderUri = Uri.parse("content://com.google.android.music.MusicContent/audio");
	    	String[] projection = { "title", "TrackType AS track_type", "LocalCopyPath AS local_copy_path",
	    							"SourceType AS source_type", "SourceId" };
	    	
	    	/* source_type values:
	    	 * 0: Local file (not used).
	    	 * 1: Unknown.
	    	 * 2: Personal, free GMusic library (used).
	    	 * 3: All Access (not used).
	    	 */
	    	String selection = "source_type=2 AND track_type=0 AND local_copy_path<>''";
	    	mApp.setPinnedSongsCursor(mContext.getContentResolver().query(googlePlayMusicContentProviderUri, 
	    																  projection, 
	    																  selection, 
	    																  null, 
	    																  null));

		}
		
		/* Load the cursor data into a temp ArrayList. If the app is closed, the cursor 
		 * will also be closed, so we need to preserve it.
		 */
		mApp.getPinnedSongsCursor().moveToPosition(-1);
		while (mApp.getPinnedSongsCursor().moveToNext()) {
			//Download the song only if it's from GMusic.
			if (getAllPinnedTracks || mApp.getPinnedSongsCursor().getString(
									  mApp.getPinnedSongsCursor().getColumnIndex(
									  DBAccessHelper.SONG_SOURCE)).equals(DBAccessHelper.GMUSIC)) {
				
		    	//Retrieve the song ID of current song and set it as the file name.
		    	String songID = "";
		    	String songTitle = "";
		    	if (mApp.getPinnedSongsCursor().getColumnIndex("SourceId")!=-1) {
		    		songID = mApp.getPinnedSongsCursor().getString(
		    				 mApp.getPinnedSongsCursor().getColumnIndex(
		    						 "SourceId"));
		    		
		    		songTitle = mApp.getPinnedSongsCursor().getString(
		    				 	mApp.getPinnedSongsCursor().getColumnIndex(
		    						 "title"));
		    	} else {
		        	songID = mApp.getPinnedSongsCursor().getString(
		       			 	 mApp.getPinnedSongsCursor().getColumnIndex(
		   		 					DBAccessHelper.SONG_ID));
		        	
		        	songTitle = mApp.getPinnedSongsCursor().getString(
		    				 	mApp.getPinnedSongsCursor().getColumnIndex(
		    						 DBAccessHelper.SONG_TITLE));
		    	}
		    	
				songIdsList.add(songID);
				songTitlesList.add(songTitle);
			}
			
		}

		//Clear out Common's cursor.
		if (mApp.getPinnedSongsCursor()!=null) {
			mApp.getPinnedSongsCursor().close();
			mApp.setPinnedSongsCursor(null);
		}
		
		//Iterate through the songs and download them.
		for (i=0; i < songIdsList.size(); i++) {
			downloadSong(songIdsList.get(i));
		}
		
    	return true;
    }

