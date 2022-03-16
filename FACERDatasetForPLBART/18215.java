    private long getSongAudioId(String artist, String album, String title) {
    	artist = artist.replace("'", "''");
    	album = album.replace("'", "''");
    	title = title.replace("'", "''");
    	
    	String selection = MediaStore.Audio.AudioColumns.ALBUM + "=" + "'" + album + "'" + " AND "
    					 + MediaStore.Audio.AudioColumns.ARTIST + "=" + "'" + artist + "'" + " AND "
    					 + MediaStore.Audio.AudioColumns.TITLE + "=" + "'" + title + "'";
    	
    	Cursor cursor = mContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
    														null, 
    														selection, 
    														null,
    														null);
    	
    	if (cursor!=null && cursor.getCount() > 0) {
    		cursor.moveToFirst();
    		return cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
    	} else {
    		return -1;
    	}
    	
    }

