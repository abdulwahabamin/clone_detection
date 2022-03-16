		public void removeArtistFromLibrary() {

			Cursor cursor = MusicLibraryEditorActivity.dbHelper.getAllSongsByArtist(mArtistName);
			if (cursor!=null && cursor.getCount() > 0) {

				for (int i=0; i < cursor.getCount(); i++) {
					cursor.moveToPosition(i);
					MusicLibraryEditorActivity.songDBIdsList.remove(cursor.getString(cursor.getColumnIndex(DBAccessHelper._ID)));
				}
				cursor.close();
				cursor = null;
				
			}
			
		}

