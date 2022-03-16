    /**
     * Starts playing mMediaPlayer2, sends out the update UI broadcast,
     * and updates the notification and any open widgets.
     *
     * Do NOT call this method before mMediaPlayer2 has been prepared.
     */
    private void startMediaPlayer2() throws IllegalStateException {
    	
    	//Set the media player's equalizer/audio fx.
    	applyMediaPlayer2EQ(getMediaPlayer2SongHelper().getId());
    	
    	//Aaaaaand let the show begin!
    	setCurrentMediaPlayer(2);
    	getMediaPlayer2().start();
    	
    	//Set the new value for mCurrentSongIndex.
    	do {
    		setCurrentSongIndex(determineNextSongIndex());
    	} while (getFailedIndecesList().contains(getCurrentSongIndex()));
    	
		getFailedIndecesList().clear();
    	
    	//Update the UI.
		String[] updateFlags = new String[] { Common.UPDATE_PAGER_POSTIION, 
											  Common.UPDATE_PLAYBACK_CONTROLS, 
											  Common.HIDE_STREAMING_BAR, 
											  Common.UPDATE_SEEKBAR_DURATION, 
											  Common.UPDATE_EQ_FRAGMENT };
		
		String[] flagValues = new String[] { getCurrentSongIndex() + "", 
											 "",
											 "", 
											 getMediaPlayer2().getDuration() + "", 
											 "" };
		
		mApp.broadcastUpdateUICommand(updateFlags, flagValues); 
		setCurrentSong(getCurrentSong());
    	
		//Start preparing the next song.
		prepareMediaPlayer(determineNextSongIndex());
    }

