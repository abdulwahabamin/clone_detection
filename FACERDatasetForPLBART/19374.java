	@Override
	public void onServiceRunning(AudioPlaybackService service) {
		//Build the cursor and pass it on to the service.
		mApp = (Common) mContext.getApplicationContext();
		mApp.setIsServiceRunning(true);
		mApp.setService(service);
		mApp.getService().setPrepareServiceListener(this);
		mApp.getService().setCurrentSongIndex(mCurrentSongIndex);
		new AsyncBuildCursorTask(false).execute();
		
	}

