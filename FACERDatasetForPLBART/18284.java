    @Override
    protected Boolean doInBackground(String... params) {
    	
		//Clear the DB and insert the new selections (along with the old ones).
		mApp.getDBAccessHelper().deleteAllMusicFolderPaths();
		try {
			mApp.getDBAccessHelper().getWritableDatabase().beginTransaction();
			
			//Retrieve a list of all keys in the hash map (key = music folder path).
			mPathsList = new ArrayList<String>(mMusicFolders.keySet());
				
			for (int i=0; i < mMusicFolders.size(); i++) {
				String path = mPathsList.get(i);
				boolean include = mMusicFolders.get(path);

				//Trim down the folder path to include only the folder and its parent.
				int secondSlashIndex = path.lastIndexOf("/", path.lastIndexOf("/")-1);
				if ((secondSlashIndex < path.length()) && secondSlashIndex!=-1)
					path = path.substring(secondSlashIndex, path.length());
				
		        ContentValues values = new ContentValues();
		        values.put(DBAccessHelper.FOLDER_PATH, path);
		        values.put(DBAccessHelper.INCLUDE, include);

		        mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.MUSIC_FOLDERS_TABLE, null, values);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
			mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
		}
		
		//Populate the UserLibraries table.
		try {
			mApp.getDBAccessHelper().getWritableDatabase().beginTransaction();
			
			//Insert the default libaries.
			ContentValues allLibrariesValues = new ContentValues();
			allLibrariesValues.put(DBAccessHelper.LIBRARY_NAME, mContext.getResources().getString(R.string.all_libraries));
			allLibrariesValues.put(DBAccessHelper.SONG_ID, "ALL_LIBRARIES");
			allLibrariesValues.put(DBAccessHelper.LIBRARY_TAG, "circle_blue_dark");
			mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.LIBRARIES_TABLE, null, allLibrariesValues);
			
			ContentValues googlePlayMusicLibrary = new ContentValues();
			googlePlayMusicLibrary.put(DBAccessHelper.LIBRARY_NAME, mContext.getResources().getString(R.string.google_play_music_no_asterisk));
			googlePlayMusicLibrary.put(DBAccessHelper.SONG_ID, DBAccessHelper.GMUSIC);
			googlePlayMusicLibrary.put(DBAccessHelper.LIBRARY_TAG, "circle_yellow_dark");
			mApp.getDBAccessHelper().getWritableDatabase().insert(DBAccessHelper.LIBRARIES_TABLE, null, googlePlayMusicLibrary);
			
			//Default to "All Libraries".
			mApp.getSharedPreferences().edit().putString(Common.CURRENT_LIBRARY, mContext.getResources().getString(R.string.all_libraries)).commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
			mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
			
			//Use "All Libraries" as the default library.
			mApp.getSharedPreferences().edit().putString(Common.CURRENT_LIBRARY, mContext.getResources().getString(R.string.all_libraries)).commit();
			
		}
    	
    	return true;
    }

