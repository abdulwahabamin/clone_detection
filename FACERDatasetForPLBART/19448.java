	/**
	 * Fires the broadcast intent that connects to Scrobble Droid.
	 */
	public static void sendBroadcast(Context mContext) {
		mContext.sendBroadcast(mScrobbleDroidIntent);
	}

