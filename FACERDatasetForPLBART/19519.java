    /**
     * Indicates if music is currently playing.
     */
    public boolean isPlayingMusic() {
    	try {
        	if (getCurrentMediaPlayer().isPlaying())
        		return true;
        	else
        		return false;
        	
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}

    }

