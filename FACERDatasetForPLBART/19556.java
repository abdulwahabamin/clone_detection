	/**
	 * Returns true if mCurrentSongIndex is pointing at the last 
	 * song in the queue. False, otherwise.
	 */
	public boolean isLastSongInQueue() {
		if (getCurrentSongIndex()==(getCursor().getCount()-1))
			return true;
		else
			return false;
		
	}

