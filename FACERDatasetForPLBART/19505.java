    /**
     * Stops the current media player. Returns true if 
     * the operation succeeded. False, otherwise.
     */
    public boolean stopPlayback() {
    	
    	try {
    		getCurrentMediaPlayer().stop();
    		
    		//Update the UI and scrobbler.
    		String[] updateFlags = new String[] { Common.UPDATE_PLAYBACK_CONTROLS };
    		String[] flagValues = new String[] { "" };
    		
    		mApp.broadcastUpdateUICommand(updateFlags, flagValues);
    		updateNotification(mApp.getService().getCurrentSong());
			updateWidgets();
			scrobbleTrack(SimpleLastFMHelper.PAUSE);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }

