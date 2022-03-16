	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		mApp.setIsBuildingLibrary(true);
		mApp.setIsScanFinished(false);
		
		if (mBuildLibraryProgressUpdate!=null)
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
			        mBuildLibraryProgressUpdate.get(i).onStartBuildingLibrary();
		
		// Acquire a wakelock to prevent the CPU from sleeping while the process is running.
		pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
		wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
								  "com.aniruddhc.acemusic.player.AsyncTasks.AsyncBuildLibraryTask");
		wakeLock.acquire();

	}

