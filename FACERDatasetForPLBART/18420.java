    /**
     * Returns the cursor based on the specified fragment.
     */
    public Cursor getFragmentCursor(Context context, String querySelection, int fragmentId) {
    	String currentLibrary = mApp.getCurrentLibraryNormalized();

	    if (currentLibrary.equals(context.getResources().getString(R.string.all_libraries))) {
	    	if (mApp.getSharedPreferences().getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
	    		querySelection += "";
	    	} else {
	    		querySelection += " AND " + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
	    	}

	    	return getFragmentCursorHelper(querySelection, fragmentId);
	    	
	    } else if (currentLibrary.equals(context.getResources().getString(R.string.google_play_music_no_asterisk))) {
	    	//Check to make sure that Google Play Music is enabled.
	    	if (mApp.getSharedPreferences().getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
	    		querySelection += " AND " + DBAccessHelper.SONG_SOURCE + "=" + "'GOOGLE_PLAY_MUSIC'";
	    		return getFragmentCursorHelper(querySelection, fragmentId);
	    	} else {
	    		return null;
	    	}
	    	
	    } else if (currentLibrary.equals(context.getResources().getString(R.string.on_this_device))) { 
	    	//Check if Google Play Music is enabled.
	    	if (mApp.getSharedPreferences().getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
	    		querySelection += " AND (" + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'" + " OR "
	    				  		 + DBAccessHelper.LOCAL_COPY_PATH + "<> '')";
	    	} else {
	    		querySelection += " AND " + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
	    	}
	    	
	    	return getFragmentCursorHelper(querySelection, fragmentId);
	    	
    	} else {
	    	if (mApp.getSharedPreferences().getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
			    querySelection += " AND " + DBAccessHelper.LIBRARY_NAME + "=" + "'" + currentLibrary + "'";
	    	} else {
			    querySelection += " AND " + DBAccessHelper.LIBRARY_NAME + "=" + "'" + currentLibrary + "'"
	    	              	   + " AND " + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
	    	}
	    	
	    	return getFragmentCursorInLibraryHelper(querySelection, fragmentId);
	    }
	    
    }

