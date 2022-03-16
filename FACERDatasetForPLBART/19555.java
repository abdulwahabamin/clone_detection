	/**
	 * Returns true if mCurrentSongIndex is pointing at the first 
	 * song in the queue and there is more than one song in the 
	 * queue. False, otherwise.
	 */
	public boolean isFirstSongInQueue() {
		if (getCurrentSongIndex()==0 && getCursor().getCount() > 1)
			return true;
		else
			return false;
		
	}

