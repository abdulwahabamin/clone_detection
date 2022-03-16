	/**
	 * Helper method that calls all the required method(s) 
	 * that initialize music playback. This method should 
	 * always be called when the cursor for the service 
	 * needs to be changed.
	 */
	public void initPlayback(Context context, 
						     String querySelection,
							 int playbackRouteId,
							 int currentSongIndex,
							 boolean showNowPlayingActivity,
                             boolean playAll) {

		mApp = (Common) mContext.getApplicationContext();
		mQuerySelection = querySelection;
		mPlaybackRouteId = playbackRouteId;
		mCurrentSongIndex = currentSongIndex;
        mPlayAll = playAll;
		
		if (showNowPlayingActivity) {
			//Launch NowPlayingActivity.
			Intent intent = new Intent(mContext, NowPlayingActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putExtra(NowPlayingActivity.START_SERVICE, true);
			mContext.startActivity(intent);
			
		} else {
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
		
	}

