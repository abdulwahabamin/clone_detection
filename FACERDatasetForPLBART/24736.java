	public static Cursor getAllUniqueGenres(Context context) {
		ContentResolver contentResolver = context.getContentResolver();
		String[] projection = { MediaStore.Audio.Genres._ID, 
							    MediaStore.Audio.Genres.NAME };
		
		return contentResolver.query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, 
									 projection, 
									 null, 
									 null, 
									 MediaStore.Audio.Genres.NAME + " ASC");
		
	}

