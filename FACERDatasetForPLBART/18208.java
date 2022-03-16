    @Override
    protected Void doInBackground(String... params) {

    	//Delete the library if it currently exists.
    	mApp.getDBAccessHelper().deleteLibrary(mLibraryName, mLibraryColorCode);
    	
    	try {
    		mApp.getDBAccessHelper().getWritableDatabase().beginTransaction();
    		
    		//HashSets aren't meant to be browsable, so convert it into an array.
    		String[] songIdsArray = new String[mSongDBIds.size()];
    		mSongDBIds.toArray(songIdsArray);

    		//Loop through the array and add the songIDs to the library.
    		for (int i=0; i < songIdsArray.length; i++) {
    			ContentValues values = new ContentValues();
    			values.put(DBAccessHelper.LIBRARY_NAME, mLibraryName);
    			values.put(DBAccessHelper.SONG_ID, songIdsArray[i]);
    			values.put(DBAccessHelper.LIBRARY_TAG, mLibraryColorCode);
    			
        		mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.LIBRARIES_TABLE, null, values);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	} finally {
    		mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
    		mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
    	}
    	
    	return null;
	    
    }

