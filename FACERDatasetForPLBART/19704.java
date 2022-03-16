    /**
     * Download Manager implementation for pinning songs.
     */
    public void queueSongsToPin(boolean getAllPinnedSongs, boolean pinPlaylist, String selection) {
    	//If the current cursor is empty or null, retrieve the cursor using the selection parameter.
    	if (mPinnedSongsCursor==null || mPinnedSongsCursor.getCount()<=0) {

    		if (getAllPinnedSongs==true) {
    			mPinnedSongsCursor = null;
    			mIsFetchingPinnedSongs = true;
    			Toast.makeText(mContext, R.string.getting_pinned_songs, Toast.LENGTH_LONG).show();
    		} else if (pinPlaylist==true) {
    			//Pinning from a playlist, so we'll need to use a db call that utilizes a JOIN.
    			mPinnedSongsCursor = mDBAccessHelper.getAllSongsInPlaylistSearchable(selection);
    		} else {
    			//Check if we're pinning a smart playlist.
    			if (selection.equals("TOP_25_PLAYED_SONGS")) {
    	            mPinnedSongsCursor = mDBAccessHelper.getTop25PlayedTracks(selection);
    	        } else if (selection.equals("RECENTLY_ADDED")) {
    	        	mPinnedSongsCursor = mDBAccessHelper.getRecentlyAddedSongs(selection);
    	        } else if (selection.equals("TOP_RATED")) {
    	        	mPinnedSongsCursor = mDBAccessHelper.getTopRatedSongs(selection);
    	        } else if (selection.equals("RECENTLY_PLAYED")) {
    	        	mPinnedSongsCursor = mDBAccessHelper.getRecentlyPlayedSongs(selection);
    	        } else {
    	        	//Not playing from a smart playlist. Just use a regular db query that searches songs.
        			mPinnedSongsCursor = mDBAccessHelper.getAllSongsSearchable(selection);
    	        }

    		}

    		Intent intent = new Intent(this, PinGMusicSongsService.class);
    		startService(intent);

    	} else {
    		//mPinnedSongsCursor already has songs queued, so append a new intermCursor;
    		Cursor intermCursor = null;
    		if (getAllPinnedSongs==true) {
    			Toast.makeText(mContext, R.string.wait_until_pinning_complete, Toast.LENGTH_SHORT).show();
    			return;
    		} else if (pinPlaylist==true) {
    			//Pinning from a playlist, so we'll need to use a db call that utilizes a JOIN.
    			intermCursor = mDBAccessHelper.getAllSongsInPlaylistSearchable(selection);
    		} else {
    			//Check if we're pinning a smart playlist.
    			if (selection.equals("TOP_25_PLAYED_SONGS")) {
    				intermCursor = mDBAccessHelper.getTop25PlayedTracks(selection);
    	        } else if (selection.equals("RECENTLY_ADDED")) {
    	        	intermCursor = mDBAccessHelper.getRecentlyAddedSongs(selection);
    	        } else if (selection.equals("TOP_RATED")) {
    	        	intermCursor = mDBAccessHelper.getTopRatedSongs(selection);
    	        } else if (selection.equals("RECENTLY_PLAYED")) {
    	        	intermCursor = mDBAccessHelper.getRecentlyPlayedSongs(selection);
    	        } else {
    	        	//Not playing from a smart playlist. Just use a regular db query that searches songs.
    	        	intermCursor = mDBAccessHelper.getAllSongsSearchable(selection);
    	        }

    		}

    		Cursor[] cursorArray = { mPinnedSongsCursor, intermCursor };
     		MergeCursor mergeCursor = new MergeCursor(cursorArray);
     		mPinnedSongsCursor = (Cursor) mergeCursor;

    	}

    }

