	/**
	 * Queries MediaStore and returns a cursor with all unique albums, 
	 * their ids, and their number of songs.
	 */
	public static Cursor getAllUniqueAlbums(Context context) {
		ContentResolver contentResolver = context.getContentResolver();
		String[] projection = { MediaStore.Audio.Albums._ID, 
							    MediaStore.Audio.Albums.ALBUM, 
							    MediaStore.Audio.Albums.NUMBER_OF_SONGS };
		
		return contentResolver.query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, 
									 projection, 
									 null, 
									 null, 
									 MediaStore.Audio.Albums.ALBUM + " ASC");
		
	}

