	/**
	 * Returns the Uri of a song's data source. 
	 * If the song is a local file, its file path is 
	 * returned. If the song is from GMusic, its local 
	 * copy path is returned (if it exists). If no local 
	 * copy exists, the song's remote URL is requested 
	 * from Google's servers and a temporary placeholder 
	 * (URI_BEING_LOADED) is returned.
	 */
	private Uri getSongDataSource(SongHelper songHelper) {

		if (songHelper.getSource().equals(DBAccessHelper.GMUSIC)) {
			
			//Check if a local copy of the song exists.
			if (songHelper.getLocalCopyPath()!=null && 
				songHelper.getLocalCopyPath().length() > 2) {
				
				//Double check to make sure that the local copy file exists.
				if (new File(songHelper.getLocalCopyPath()).exists()) {
					//The local copy exists. Return its path.
					return Uri.parse(songHelper.getLocalCopyPath());
				} else {
					//The local copy doesn't exist. Request the remote URL and return a placeholder Uri.
					AsyncGetSongStreamURLTask task = new AsyncGetSongStreamURLTask(mContext, songHelper.getId());
					task.execute();
					
					return URI_BEING_LOADED;
				}
				
			} else {
				//Request the remote URL and return a placeholder Uri.
				AsyncGetSongStreamURLTask task = new AsyncGetSongStreamURLTask(mContext, songHelper.getId());
				task.execute();
				
				return URI_BEING_LOADED;			
			}
			
		} else {
			//Return the song's file path.
			return Uri.parse(songHelper.getFilePath());
		}
		
	}

