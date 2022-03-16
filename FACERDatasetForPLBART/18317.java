		@Override
		protected String doInBackground(String... params) {
			//Check if the user is adding or removing an artist from the blacklist.
			String operation = params[0];
			if (operation.equals("ADD")) {
				
				//Get a list of all songs in the album.
				Cursor cursor = mApp.getDBAccessHelper().getAllSongsByArtist(mArtistName);
				if (cursor.getCount() > 0) {
					for (int i=0; i < cursor.getCount(); i++) {
						cursor.moveToPosition(i);
						String songId = cursor.getString(cursor.getColumnIndex(DBAccessHelper._ID));
						
						//Update the HashMap.
						BlacklistManagerActivity.songIdBlacklistStatusPair.remove(songId);
						BlacklistManagerActivity.songIdBlacklistStatusPair.put(songId, true);
						
					}
					
				}
				
				if (cursor!=null) {
					cursor.close();
					cursor = null;
				}
				
			} else {
				//Get a list of all songs in the album.
				Cursor cursor = mApp.getDBAccessHelper().getAllSongsByArtist(mArtistName);
				if (cursor.getCount() > 0) {
					for (int i=0; i < cursor.getCount(); i++) {
						cursor.moveToPosition(i);
						String songId = cursor.getString(cursor.getColumnIndex(DBAccessHelper._ID));
						
						//Update the HashMap.
						BlacklistManagerActivity.songIdBlacklistStatusPair.remove(songId);
						BlacklistManagerActivity.songIdBlacklistStatusPair.put(songId, false);
						
					}
					
				}
				
				if (cursor!=null) {
					cursor.close();
					cursor = null;
				}
				
			}
			
			return null;
		}

