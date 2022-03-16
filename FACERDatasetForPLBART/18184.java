	@Override
    protected Void doInBackground(String... params) {
		
		/* 
		 * Get a cursor of songs from MediaStore. The cursor 
		 * is limited by the folders that have been selected 
		 * by the user.
		 */
		mCurrentTask = mContext.getResources().getString(R.string.building_music_library);
		Cursor mediaStoreCursor = getSongsFromMediaStore();
		
		/* 
		 * Transfer the content in mediaStoreCursor over to 
		 * Jams' private database.
		 */
		if (mediaStoreCursor!=null) {
			saveMediaStoreDataToDB(mediaStoreCursor);
			mediaStoreCursor.close();
		}

    	//Save EQ presets to the database.
		saveEQPresets();

        //Notify all listeners that the MediaStore transfer is complete.
        publishProgress(new String[] { "MEDIASTORE_TRANSFER_COMPLETE" });

		//Save album art paths for each song to the database.
		getAlbumArt();
		
    	return null;
    }

