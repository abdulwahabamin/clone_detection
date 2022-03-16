	/**
	 * Sets the A-B Repeat song markers.
	 * 
	 * @param pointA The duration to repeat from (in millis).
	 * @param pointB The duration to repeat until (in millis).
	 */
	public void setRepeatSongRange(int pointA, int pointB) {
		mRepeatSongRangePointA = pointA;
		mRepeatSongRangePointB = pointB;
		getCurrentMediaPlayer().seekTo(pointA);
		mHandler.postDelayed(checkABRepeatRange, 100);
	}

