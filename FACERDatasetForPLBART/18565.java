	public static ArrayList<String> getAllSongsByArtist(String artistName) {
		ArrayList<String> songURIsList = new ArrayList<String>();

		//Escape any rogue apostrophes.
		if (artistName.contains("'")) {
			artistName = artistName.replace("'", "''");
		}
		
		String selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + artistName + "'"
						 + " AND " + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
		
		String[] projection = { DBAccessHelper._ID, DBAccessHelper.SONG_FILE_PATH, 
								DBAccessHelper.SONG_SOURCE, DBAccessHelper.SONG_ID };
		
		Cursor cursor = mApp.getDBAccessHelper().getWritableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
															 projection,
															 selection, 
															 null, 
															 null, 
															 null, 
															 null);
		
		cursor.moveToFirst();
		if (cursor.getCount()!=0) {
			
			do {
				songURIsList.add(cursor.getString(1));
				songSourcesList.add(cursor.getString(2));
				songIdsList.add(cursor.getString(3));
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return songURIsList;
	}

