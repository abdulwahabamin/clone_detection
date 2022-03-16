    /**
     * Returns an instance of SongHelper. This 
     * object can be used to pull details about 
     * the current song.
     */
    public SongHelper getCurrentSong() {
    	if (getCurrentMediaPlayer()==mMediaPlayer) {
    		return mMediaPlayerSongHelper;
    	} else {
    		return mMediaPlayer2SongHelper;
    	}
    	
    }

