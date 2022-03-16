	/**
	 * Fires the broadcast intent that connects to Simple lastFM Scrobbler.
	 */
	public static void sendBroadcast(Context mContext) {
		mContext.sendBroadcast(mSimpleLastFMIntent);
	}

