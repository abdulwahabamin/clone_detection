	public static void removeFromPlaylist(ContentResolver resolver, int audioId, long playlistId) {
	    String[] cols = new String[] {"count(*)"};
	    Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playlistId);
	    Cursor cur = resolver.query(uri, cols, null, null, null);
	    cur.moveToFirst();
	    final int base = cur.getInt(0);
	    cur.close();
	    ContentValues values = new ContentValues();
	
	    resolver.delete(uri, MediaStore.Audio.Playlists.Members.AUDIO_ID + "=" + audioId, null);
	    
	}

