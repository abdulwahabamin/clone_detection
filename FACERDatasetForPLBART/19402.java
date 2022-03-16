		public void removeAlbumFromLibrary() {
			
			Cursor cursor = mApp.getDBAccessHelper().getAllSongsInAlbum(mAlbumName, mArtistName);
			if (cursor!=null && cursor.getCount() > 0) {

				for (int i=0; i < cursor.getCount(); i++) {
					cursor.moveToPosition(i);
					PlaylistEditorActivity.songDBIdsList.remove(cursor.getString(cursor.getColumnIndex(DBAccessHelper._ID)));
				}
				cursor.close();
				cursor = null;
				
			}
			
		}

