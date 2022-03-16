	/**
	 * Clears the A-B Repeat song markers.
	 */
	public void clearABRepeatRange() {
		mHandler.removeCallbacks(checkABRepeatRange);
		mRepeatSongRangePointA = 0;
		mRepeatSongRangePointB = 0;
		mApp.getSharedPreferences().edit().putInt(Common.REPEAT_MODE, Common.REPEAT_OFF);
	}

