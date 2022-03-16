	/**
	 * Queries MediaStore and returns a cursor with songs limited 
	 * by the selection parameter.
	 */
	public static Cursor getAllSongsWithSelection(Context context, 
												  String selection, 
												  String[] projection, 
												  String sortOrder) {
		
		ContentResolver contentResolver = context.getContentResolver();
		Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		
		return contentResolver.query(uri, projection, selection, null, sortOrder);
		
	}

