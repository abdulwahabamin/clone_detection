	private void initScanProcess(int scanCode) {
		
		//Start the service that will start scanning the user's library/caching album art.
		mApp.setIsBuildingLibrary(true);
		buildingLibraryLayout.setVisibility(View.VISIBLE);
		if (scanCode==0) {
        	Intent intent = new Intent(this, BuildMusicLibraryService.class);
        	intent.putExtra("SCAN_TYPE", "RESCAN_ALBUM_ART");
			startService(intent);
			
	        mApp.getSharedPreferences().edit().putBoolean("RESCAN_ALBUM_ART", false).commit();
			
		} else if (scanCode==1) {
	    	Intent intent = new Intent(this, BuildMusicLibraryService.class);
	    	intent.putExtra("SCAN_TYPE", "FULL_SCAN");
			startService(intent);
			
			mApp.getSharedPreferences().edit().putBoolean("REBUILD_LIBRARY", false).commit();
		}
		
		//Initialize the runnable that will fire once the scan process is complete.
		mHandler.post(scanFinishedCheckerRunnable);
		
	}

