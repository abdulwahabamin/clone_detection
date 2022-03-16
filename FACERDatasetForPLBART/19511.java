    /**
     * Checks which MediaPlayer object is currently in use, and 
     * starts preparing the other one.
     */
    public void prepareAlternateMediaPlayer() {
    	if (mCurrentMediaPlayer==1)
    		prepareMediaPlayer2(determineNextSongIndex());
    	else
    		prepareMediaPlayer(determineNextSongIndex());
    	
    }

