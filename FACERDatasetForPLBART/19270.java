		public void addAlbumToLibrary() {
			
			Cursor cursor = MusicLibraryEditorActivity.dbHelper.getAllSongsInAlbum(mAlbumName, mArtistName);
			if (cursor!=null && cursor.getCount() > 0) {

				for (int i=0; i < cursor.getCount(); i++) {
					cursor.moveToPosition(i);
					MusicLibraryEditorActivity.songDBIdsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper._ID)));
				}
				cursor.close();
				cursor = null;
				
			}
			
		}

