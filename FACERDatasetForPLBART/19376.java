	@Override
	public void onNowPlayingActivityReady() {
		//Start the playback service if it isn't running.
		if (!mApp.isServiceRunning()) {
			startService();
		} else {
			//Call the callback method that will start building the new cursor.
			mApp.getService()
				.getPrepareServiceListener()
				.onServiceRunning(mApp.getService());
		}
		
	}

