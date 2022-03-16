	public static Cursor getAllSongs(Context context, 
									 String[] projection, 
									 String sortOrder) {
		
		ContentResolver contentResolver = context.getContentResolver();
		Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
		return contentResolver.query(uri, null, selection, null, sortOrder);
		
	}

