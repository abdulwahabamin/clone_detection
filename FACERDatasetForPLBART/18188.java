	/**
	 * Builds a HashMap of all songs and their genres.
	 */
	private void buildGenresLibrary() {
		//Get a cursor of all genres in MediaStore.
		Cursor genresCursor = mContext.getContentResolver().query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI,
																  new String[] { MediaStore.Audio.Genres._ID, MediaStore.Audio.Genres.NAME },
		            								  			  null, 
		            								  			  null, 
		            								  			  null);
		 
		//Iterate thru all genres in MediaStore.
        for (genresCursor.moveToFirst(); !genresCursor.isAfterLast(); genresCursor.moveToNext()) {
        	String genreId = genresCursor.getString(0);
        	String genreName = genresCursor.getString(1);

            if (genreName==null || genreName.isEmpty() ||
                genreName.equals(" ") || genreName.equals("   ") ||
                genreName.equals("    "))
                genreName = mContext.getResources().getString(R.string.unknown_genre);

        	/* Grab a cursor of songs in the each genre id. Limit the songs to 
        	 * the user defined folders using mMediaStoreSelection.
        	 */
        	Cursor cursor = mContext.getContentResolver().query(makeGenreUri(genreId),
        														new String[] { MediaStore.Audio.Media.DATA },
				     											mMediaStoreSelection,
				     											null, 
				     											null);
        	 
        	//Add the songs' file paths and their genre names to the hash.
        	if (cursor!=null) {
        		for (int i=0; i < cursor.getCount(); i++) {
        			cursor.moveToPosition(i);
        			mGenresHashMap.put(cursor.getString(0), genreName);
                    mGenresSongCountHashMap.put(genreName, cursor.getCount());
            	}
            	 
            	cursor.close();
        	}
        	 
        }         
         
        if (genresCursor!=null)
        	genresCursor.close();
         
	}

