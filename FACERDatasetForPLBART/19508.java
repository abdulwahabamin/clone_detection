    /**
     * Skips to the specified track index (if there is one) and starts 
     * playing it. Returns true if the operation succeeded. 
     * False, otherwise.
     */
    public boolean skipToTrack(int trackIndex) {
    	try {
    		//Reset both MediaPlayer objects.
    		getMediaPlayer().reset();
    		getMediaPlayer2().reset();
            clearCrossfadeCallbacks();
    		
    		//Loop the players if the repeat mode is set to repeat the current song.
    		if (getRepeatMode()==Common.REPEAT_SONG) {
    			getMediaPlayer().setLooping(true);
    			getMediaPlayer2().setLooping(true);
    		}
    		
    		//Remove crossfade runnables and reset all volume levels.
			getHandler().removeCallbacks(crossFadeRunnable);
			getMediaPlayer().setVolume(1.0f, 1.0f);
			getMediaPlayer2().setVolume(1.0f, 1.0f);
    		
    		//Update the song index.
    		setCurrentSongIndex(trackIndex);
    		
    		//Update the UI.
    		String[] updateFlags = new String[] { Common.UPDATE_PAGER_POSTIION };
    		String[] flagValues = new String[] { getCurrentSongIndex() + "" };
    		mApp.broadcastUpdateUICommand(updateFlags, flagValues);
    		
    		//Start the playback process.
    		mFirstRun = true;
    		prepareMediaPlayer(trackIndex);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }

