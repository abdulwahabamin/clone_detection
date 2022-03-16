	@SuppressLint("InlinedApi") 
	void doBindService(boolean startService) {
		Log.i(TAG, "Binding to the service!");
		bindService(new Intent(this, MusicPlaybackService.class), mConnection,
				Context.BIND_IMPORTANT | Context.BIND_AUTO_CREATE);
		mIsBound = true;
		// Need to start the service so it won't be stopped when this activity is destroyed.
		// https://developer.android.com/guide/components/bound-services.html
		if(startService){
			startService(new Intent(this, MusicPlaybackService.class));
		}
	}

