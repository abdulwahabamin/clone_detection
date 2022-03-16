	/**
	 * Initializes the action intent that will be sent to 
	 * Simple lastFM Scrobbler. This method should always 
	 * be called when sending a new set of data to the 
	 * scrobbling app.
	 */
	public static void initializeActionIntent() {
		mSimpleLastFMIntent = null;
		mSimpleLastFMIntent = new Intent("com.adam.aslfms.notify.playstatechanged");
	}

