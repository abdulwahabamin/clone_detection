    @Override
    protected void onPreExecute() {
    	super.onPreExecute();
    	
    	//Hide the actionbar.
    	mApp.setIsBuildingLibrary(true);
    	
    	//Acquire a wakelock to prevent the CPU from sleeping while the process is running.
    	pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
    	wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "com.aniruddhc.acemusic.player.AsyncTasks.AsyncGetGooglePlayMusicMetadata");
    	wakeLock.acquire();
    	
    	//Set the initial setting of the progressbar as indeterminate.
    	currentTask = mContext.getResources().getString(R.string.contacting_google_play_music);
    	
    }

