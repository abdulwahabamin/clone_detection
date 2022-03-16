	@Override
	public void onReceive(Context context, Intent intent) {
		
		mApp = (Common) context.getApplicationContext();
		
		//Retrieve the new song's index.
		int index = intent.getIntExtra("INDEX", 0);
		
		if (mApp.isServiceRunning())
			mApp.getService().skipToTrack(index);

	}

