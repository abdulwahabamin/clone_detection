    /**
     * Starts/resumes the current media player. Returns true if 
     * the operation succeeded. False, otherwise.
     */
    public boolean startPlayback() {
    	
    	try {
    		//Check to make sure we have audio focus.
    		if (checkAndRequestAudioFocus()) {
        		getCurrentMediaPlayer().start();
        		
        		//Update the UI and scrobbler.
        		String[] updateFlags = new String[] { Common.UPDATE_PLAYBACK_CONTROLS };
        		String[] flagValues = new String[] { "" };
        		
        		mApp.broadcastUpdateUICommand(updateFlags, flagValues);
        		updateNotification(mApp.getService().getCurrentSong());
    			updateWidgets();
    			scrobbleTrack(SimpleLastFMHelper.START);
    			
    		} else {
    			return false;
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }

