	/**
	 * Returns the appropriate notification based on the device's 
	 * API level.
	 */
	private Notification buildNotification(SongHelper songHelper) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return buildJBNotification(songHelper);
		else
			return buildICSNotification(songHelper);
	}

