        @Override
        public void remove(int which) {
        	
        	//Before we remove the item, retrieve its parameters so we can form a where clause.
        	String element = elementNameList.get(which);
        	
        	String artist = "";
        	if (artistNameList.size()!=0) {
            	artist = artistNameList.get(which);
        	}
        	
        	String filePath = "";
        	if (filePathList.size()!=0) {
            	filePath = filePathList.get(which);
        	}
        	
        	//Escape any rogue apostrophes.
        	if (element.contains("'")) {
        		element = element.replace("'", "''");
        	}
        	
        	if (artist.contains("'")) {
        		artist = artist.replace("'", "''");
        	}
        	
        	if (filePath.contains("'")) {
        		filePath = filePath.replace("'", "''");
        	}
        	
            adapter.remove(adapter.getItem(which));
            
            //Remove the elements in the actual ArrayLists.
            artistNameList.remove(which);
            
            //Unblacklist the element based on the MANAGER_TYPE.
            String where = "";
            if (MANAGER_TYPE.equals("ARTISTS")) {
            	where = DBAccessHelper.SONG_ARTIST + "=" + "'" + element + "'";
            	mApp.getDBAccessHelper().setBlacklistForArtist(element, false);
            	
            } else if (MANAGER_TYPE.equals("ALBUMS")) {
            	where = DBAccessHelper.SONG_ARTIST + "=" + "'" + element + "'";
            	mApp.getDBAccessHelper().setBlacklistForAlbum(element, artist, false);
            	
            } else if (MANAGER_TYPE.equals("SONGS")) {
            	where = DBAccessHelper.SONG_ARTIST + "=" + "'" + element + "'";
            	mApp.getDBAccessHelper().setBlacklistForSong(songIdsList.get(which), false);
            	
            } else if (MANAGER_TYPE.equals("PLAYLISTS")) {
/*            	DBAccessHelper playlistsDBHelper = new DBAccessHelper(mContext);
            	where = DBAccessHelper.SONG_ARTIST + "=" + "'" + element + "'";
            	playlistsDBHelper.unBlacklistPlaylist(filePath);
            	playlistsDBHelper.close();*/
            	
            }
            
            Toast.makeText(mContext, R.string.item_removed_from_blacklist, Toast.LENGTH_LONG).show();
            
        }

