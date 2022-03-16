	public static ArrayList<String> getAllSongsInAlbum(String albumName, String artistName) {
		ArrayList<String> songURIsList = new ArrayList<String>();
		
		//Escape any rogue apostrophes.
		if (albumName.contains("'")) {
			albumName = albumName.replace("'", "''");
		}
		
		if (artistName.contains("'")) {
			artistName = artistName.replace("'", "''");
		}
		
		String selection = " AND " + DBAccessHelper.SONG_ALBUM + "=" + "'" + albumName + "'" + " AND "
						 + DBAccessHelper.SONG_ARTIST + "=" + "'" + artistName + "'" + " AND "
						 + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
		
		Cursor cursor = mApp.getDBAccessHelper().getAllSongsByAlbumArtist(selection);
		cursor.moveToFirst();
		if (cursor.getCount()!=0) {
			
			do {
				songURIsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)));
				songSourcesList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_SOURCE)));
				songIdsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ID)));
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return songURIsList;
	}

