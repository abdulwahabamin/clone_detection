	/**
	 * Starts AudioPlaybackService. Once the service is running, we get a
	 * callback to onServiceRunning() (see below). That's where the method to 
	 * build the cursor is called.
	 */
	private void startService() {
		Intent intent = new Intent(mContext, AudioPlaybackService.class);
		mContext.startService(intent);
	}

