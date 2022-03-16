    /**
     * Starts playing mMediaPlayer and sends out the update UI broadcast, 
     * and updates the notification and any open widgets.
     *  
     * Do NOT call this method before mMediaPlayer has been prepared.
     */
    private void startMediaPlayer() throws IllegalStateException {
    	
    	//Set the media player's equalizer/audio fx.
    	applyMediaPlayerEQ(getMediaPlayerSongHelper().getId());
    	
    	//Aaaaand let the show begin!
    	setCurrentMediaPlayer(1);
    	getMediaPlayer().start();
    	
    	//Set the new value for mCurrentSongIndex.
    	if (mFirstRun==false) {
        	do {
        		setCurrentSongIndex(determineNextSongIndex());
        	} while (getFailedIndecesList().contains(getCurrentSongIndex()));
    		
    		getFailedIndecesList().clear();
    		
    	} else {
    		while (getFailedIndecesList().contains(getCurrentSongIndex())) {
    			setCurrentSongIndex(determineNextSongIndex());
    		}

            //Initialize the crossfade runnable.
            if (mHandler!=null && mApp.isCrossfadeEnabled()) {
                mHandler.post(startCrossFadeRunnable);
            }
    		
    	}

    	
    	//Update the UI.
		String[] updateFlags = new String[] { Common.UPDATE_PAGER_POSTIION, 
											  Common.UPDATE_PLAYBACK_CONTROLS, 
											  Common.HIDE_STREAMING_BAR, 
											  Common.UPDATE_SEEKBAR_DURATION, 
											  Common.UPDATE_EQ_FRAGMENT };
		
		String[] flagValues = new String[] { getCurrentSongIndex() + "", 
											 "",
											 "", 
											 getMediaPlayer().getDuration() + "", 
											 "" };
		
		mApp.broadcastUpdateUICommand(updateFlags, flagValues); 
		setCurrentSong(getCurrentSong());
		
		//Start preparing the next song.
		prepareMediaPlayer2(determineNextSongIndex());
    }

