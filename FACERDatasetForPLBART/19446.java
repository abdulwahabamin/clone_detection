	/**
	 * Initializes the action intent that will be sent to 
	 * Scrobble Droid. This method should always 
	 * be called when sending a new set of data to the 
	 * scrobbling app.
	 */
	public static void initializeActionIntent() {
		mScrobbleDroidIntent = null;
		mScrobbleDroidIntent = new Intent("net.jjc1138.android.scrobbler.action.MUSIC_STATUS");
	}

