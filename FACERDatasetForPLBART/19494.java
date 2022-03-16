	/**
	 * Deploys the current track's data to the specified 
	 * scrobbler.
	 * 
	 * @param state The scrobble state.
	 */
	public void scrobbleTrack(int state) {
		
		//If scrobbling is enabled, send out the appropriate action events.
		if (mApp.getSharedPreferences().getInt("SCROBBLING", 0)==0) {
			//Scrobbling is disabled.
			return;
		} 
		
		//Get the metadata of the track.
		getCursor().moveToPosition(mPlaybackIndecesList.get(mCurrentSongIndex));
		String songTitle = getCursor().getString(getCursor().getColumnIndex(DBAccessHelper.SONG_TITLE));
		String songArtist = getCursor().getString(getCursor().getColumnIndex(DBAccessHelper.SONG_ARTIST));
		String songAlbum = getCursor().getString(getCursor().getColumnIndex(DBAccessHelper.SONG_ALBUM));
		
		int songDurationInSecs;
		try {
			songDurationInSecs = getCursor().getInt(getCursor().getColumnIndex(DBAccessHelper.SONG_DURATION)) / 1000;
		} catch (Exception e) {
			songDurationInSecs = 0;
		}
		
		
		if (mApp.getSharedPreferences().getInt("SCROBBLING", 0)==1) {
			//Simple LastFM Helper.
			SimpleLastFMHelper.initializeActionIntent();
			SimpleLastFMHelper.attachMetadata(state, songArtist, songAlbum, songTitle, songDurationInSecs);
			SimpleLastFMHelper.sendBroadcast(mContext);
			
		} else if (mApp.getSharedPreferences().getInt("SCROBBLING", 0)==2) {
			//Scrobble Droid.
			ScrobbleDroidHelper.initializeActionIntent();
			if (state==SimpleLastFMHelper.START || state==SimpleLastFMHelper.RESUME) {
				ScrobbleDroidHelper.attachMetadata(true, songArtist, songAlbum, songTitle, songDurationInSecs);
			} else if (state==SimpleLastFMHelper.PAUSE) {
				ScrobbleDroidHelper.attachMetadata(false, songArtist, songAlbum, songTitle, songDurationInSecs);
			}
			
			ScrobbleDroidHelper.sendBroadcast(mContext);
		}
		
	}

