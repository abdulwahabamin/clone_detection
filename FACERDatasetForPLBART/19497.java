    /**
     * Increments mCurrentSongIndex based on mErrorCount. 
     * Returns the new value of mCurrentSongIndex.
     */
    public int incrementCurrentSongIndex() {
    	if ((getCurrentSongIndex()+1) < getCursor().getCount())
    		mCurrentSongIndex++;

    	return mCurrentSongIndex;
    }

