	/**
	 * Purges the cache every (DELAY_BEFORE_PURGE) milliseconds.
	 * @see DELAY_BEFORE_PURGE
	 */
	private void resetPurgeTimer() {
		purgeHandler.removeCallbacks(purger);
		purgeHandler.postDelayed(purger, DELAY_BEFORE_PURGE);
	}

