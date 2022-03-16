	/**
	 * Loops through a cursor of all local songs in 
	 * the library and searches for their album art.
	 */
	private void getAlbumArt() {
		
		//Get a cursor with a list of all local music files on the device.
		Cursor cursor = mApp.getDBAccessHelper().getAllLocalSongs();
		mCurrentTask = mContext.getResources().getString(R.string.building_album_art);
		
		if (cursor==null || cursor.getCount() < 1)
			return;
		
		//Tracks the progress of this method.
		int subProgress = 0;
		if (cursor.getCount()!=0) {
			subProgress = 750000/(cursor.getCount());
		} else {
			subProgress = 750000/1;
		}

		try {
			mApp.getDBAccessHelper().getWritableDatabase().beginTransactionNonExclusive();
			
			//Loop through the cursor and retrieve album art.
			for (int i=0; i < cursor.getCount(); i++) {
				
				try {
	 				cursor.moveToPosition(i);
	 				mOverallProgress += subProgress;
					publishProgress();
					
					String filePath = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH));
					String artworkPath = "";
					if (mApp.getSharedPreferences().getInt("ALBUM_ART_SOURCE", 0)==0 || 
						mApp.getSharedPreferences().getInt("ALBUM_ART_SOURCE", 0)==1) {
						artworkPath = getEmbeddedArtwork(filePath);
					} else {
						artworkPath = getArtworkFromFolder(filePath);
					}
						
					String normalizedFilePath = filePath.replace("'", "''");
					
					//Store the artwork file path into the DB.
					ContentValues values = new ContentValues();
					values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, artworkPath);
					String where = DBAccessHelper.SONG_FILE_PATH + "='" + normalizedFilePath + "'";
					
					mApp.getDBAccessHelper().getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, values, where, null);
                    mApp.getDBAccessHelper().getWritableDatabase().yieldIfContendedSafely();
                } catch (Exception e) {
					e.printStackTrace();
					continue;
				}

			}
			
			mApp.getDBAccessHelper().getWritableDatabase().setTransactionSuccessful();
			mApp.getDBAccessHelper().getWritableDatabase().endTransaction();
			cursor.close();
			cursor = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

