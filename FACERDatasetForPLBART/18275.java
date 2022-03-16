	@Override
    protected Boolean doInBackground(String... params) {
		
		//Delete the specified local copies of the song(s) and remove the local copy reference from the DB.
		Cursor cursor = null;
		DBAccessHelper dbHelper = new DBAccessHelper(mContext);
		if (mSmartPlaylistCursor==null) {
			mSelection += " AND " + DBAccessHelper.SONG_SOURCE + "=" + "'GOOGLE_PLAY_MUSIC'";
			cursor = dbHelper.getAllSongsSearchable(mSelection);
		} else {
			cursor = mSmartPlaylistCursor;
		}
		
		if (cursor!=null) {
			for (int i=0; i < cursor.getCount(); i++) {
				try {
					cursor.moveToPosition(i);
					String localCopyPath = cursor.getString(cursor.getColumnIndex(DBAccessHelper.LOCAL_COPY_PATH));
					String songID = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ID));
					
					File file = new File(localCopyPath);
					if (file!=null && file.exists()) {
						file.delete();
					}
					
					String selection = DBAccessHelper.SONG_ID + "=" + "'" + songID + "'";
					ContentValues values = new ContentValues();
					values.put(DBAccessHelper.LOCAL_COPY_PATH, "");
					dbHelper.getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, values, selection, null);
					
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}

			}
			
		}
		
		if (dbHelper!=null) {
			dbHelper.close();
			dbHelper = null;
		}

    	return true;
    }

