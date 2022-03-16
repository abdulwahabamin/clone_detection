    /**
     * Indicates if mCurrentSongIndex points to the last 
     * song in the current queue.
     */
    public boolean isAtEndOfQueue() {
    	return (getCurrentSongIndex()==(getPlaybackIndecesList().size()-1));
    }

