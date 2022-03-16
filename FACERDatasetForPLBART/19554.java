	/**
	 * Returns true if there's only one song in the current queue.
	 * False, otherwise.
	 */
	public boolean isOnlySongInQueue() {
		if (getCurrentSongIndex()==0 && getCursor().getCount()==1)
			return true;
		else
			return false;
		
	}

