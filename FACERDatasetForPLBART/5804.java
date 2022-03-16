	/**
	 * Stops the cache purger from running until it is reset again.
	 */
	public void stopPurgeTimer(){
		purgeHandler.removeCallbacks(purger);
	}

