	public static ArrayList<String> getAllSongsByArtist(String artistName) {
		ArrayList<String> songURIsList = new ArrayList<String>();
		
		DBAccessHelper dbHelper = new DBAccessHelper(parentActivity);
		
		//Escape any rogue apostrophes.
		if (artistName.contains("'")) {
			artistName = artistName.replace("'", "''");
		}
		
		String selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + artistName + "'"
						 + " AND " + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
		
		String[] projection = { DBAccessHelper._ID, DBAccessHelper.SONG_FILE_PATH };
		
		Cursor cursor = dbHelper.getWritableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
															 projection,
															 selection, 
															 null, 
															 null, 
															 null, 
															 null);
		
		cursor.moveToFirst();
		
		if (cursor.getCount()!=0) {
			
			songURIsList.add(cursor.getString(1));
			
			while (cursor.moveToNext()) {
				songURIsList.add(cursor.getString(1));
				
			}
			
		}
		
		cursor.close();
		
		return songURIsList;
		
	}

