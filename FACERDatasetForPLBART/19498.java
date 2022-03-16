    /**
     * Decrements mCurrentSongIndex by one. Returns the new value 
     * of mCurrentSongIndex.
     */
    public int decrementCurrentSongIndex() {
    	if ((getCurrentSongIndex()-1) > -1)
    		mCurrentSongIndex--;
    	
    	return mCurrentSongIndex;
    }

