    public void setArtworkAsFile(File artworkFile, String songFilePath) {

    	File songFile = new File(songFilePath);
    	String songTitle = songFile.getName();
    	int lastDotSlash = songTitle.lastIndexOf(".");
    	String albumArtFileName = songTitle.substring(0, lastDotSlash);
    	
    	if (songFile.exists()) {
    		int lastSlashIndex = songFilePath.lastIndexOf("/");
    		String folderPath = songFilePath.substring(0, lastSlashIndex);
    		File destFile = new File(folderPath + "/" + albumArtFileName + ".jpg");
    		
    		try {
				FileUtils.copyFile(artworkFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
    		
    		//Update the album art tag in Jams' database.
			ContentValues values = new ContentValues();
			songFilePath = songFilePath.replace("'", "''");
			String where = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + songFilePath + "'";
			values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, folderPath + "/" + albumArtFileName + ".jpg");
			dbHelper.getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, values, where, null);
    		
    	}

    }

