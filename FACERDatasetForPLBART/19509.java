    /**
     * Toggles the playback state between playing and paused and 
     * returns whether the current media player is now playing 
     * music or not.
     */
    public boolean togglePlaybackState() {
    	if (isPlayingMusic())
    		pausePlayback();
    	else
    		startPlayback();
    	
    	return isPlayingMusic();
    }

