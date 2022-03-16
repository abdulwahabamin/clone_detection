    /**
     * Returns a cursor with all libraries except the default 
     * ones ("All Libraries" and "Google Play Music").
     */
    public Cursor getAllUniqueUserLibraries(Context context) {
    	String allLibraries = context.getResources().getString(R.string.all_libraries);
    	String googlePlayMusic = context.getResources().getString(R.string.google_play_music_no_asterisk);
    	allLibraries = allLibraries.replace("'", "''");
    	googlePlayMusic = googlePlayMusic.replace("'", "''");
    	
    	String rawQuery = "SELECT DISTINCT(" + LIBRARY_NAME + "), " + 
						  _ID + ", " + LIBRARY_TAG +
						  " FROM " + LIBRARIES_TABLE + " WHERE " + 
						  LIBRARY_NAME + "<>" + "'" + allLibraries + "'" + " AND " + 
						  LIBRARY_NAME + "<>" + "'" + googlePlayMusic + "'" + 
						  " GROUP BY " + LIBRARY_NAME + " ORDER BY " + _ID
						  + " ASC";
    	
    	Cursor cursor = getDatabase().rawQuery(rawQuery, null);
    	return cursor;
    }

