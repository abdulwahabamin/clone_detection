	/**
	 * Sets the current MediaPlayer's SongHelper object. Also 
	 * indirectly calls the updateNotification() and updateWidgets() 
	 * methods via the [CURRENT SONG HELPER].setIsCurrentSong() method.
	 */
	private void setCurrentSong(SongHelper songHelper) {
		if (getCurrentMediaPlayer()==mMediaPlayer) {
			mMediaPlayerSongHelper = songHelper;
			mMediaPlayerSongHelper.setIsCurrentSong();
		} else {
			mMediaPlayer2SongHelper = songHelper;
			mMediaPlayer2SongHelper.setIsCurrentSong();
		}
		
	}

