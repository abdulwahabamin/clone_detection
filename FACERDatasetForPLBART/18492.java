	/**
	 * Queries MediaStore and returns a cursor with all unique artists, 
	 * their ids, and their number of albums.
	 */
	public static Cursor getAllUniqueArtists(Context context) {
		ContentResolver contentResolver = context.getContentResolver();
		String[] projection = { MediaStore.Audio.Artists._ID, 
							    MediaStore.Audio.Artists.ARTIST, 
							    MediaStore.Audio.Artists.NUMBER_OF_ALBUMS };
		
		return contentResolver.query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, 
									 projection, 
									 null, 
									 null, 
									 MediaStore.Audio.Artists.ARTIST + " ASC");
		
	}

