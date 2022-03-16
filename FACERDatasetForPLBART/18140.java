    @Override
    protected Boolean doInBackground(Boolean... params) {
		
    	//Specifies if the user is trying to add song(s) to play next.
    	if (params.length > 0) {
    		mPlayNext = params[0];
    	}
    	
    	
		//Escape any rogue apostrophes.
		if (mArtistName!=null && mArtistName.contains("'")) {
			mArtistName = mArtistName.replace("'", "''");
		}
		
		if (mAlbumName!=null && mAlbumName.contains("'")) {
			mAlbumName = mAlbumName.replace("'", "''");
		}
		
		if (mSongTitle!=null && mSongTitle.contains("'")) {
			mSongTitle = mSongTitle.replace("'", "''");
		}
		
		if (mGenreName!=null && mGenreName.contains("''")) {
			mGenreName = mGenreName.replace("'", "''");
		}
		
		if (mAlbumArtistName!=null && mAlbumArtistName.contains("'")) {
			mAlbumArtistName = mAlbumArtistName.replace("'", "''");
		}
		
		//Fetch the cursor based on the type of set of songs that are being enqueued.
		assignCursor();

		//Check if the service is currently active.
		if (mApp.isServiceRunning()) {
			
			if (mPlayNext) {
				/* Loop through the mCursor of the songs that will be enqueued and add the 
				 * loop's counter value to the size of the current mCursor. This will add 
				 * the additional mCursor indeces of the new, merged mCursor to playbackIndecesList. 
				 * The new indeces must be placed after the current song's index.
				 */
				int playNextIndex = 0;
				if (mApp.isServiceRunning()) {
					playNextIndex = mApp.getService().getCurrentSongIndex() + 1;
				}
				
				for (int i=0; i < mCursor.getCount(); i++) {
					mApp.getService().getPlaybackIndecesList().add(playNextIndex + i, 
																   mApp.getService().getCursor().getCount() + i);
				}
				
			} else {
				/* Loop through the mCursor of the songs that will be enqueued and add the 
				 * loop's counter value to the size of the current mCursor. This will add 
				 * the additional mCursor indeces of the new, merged mCursor to playbackIndecesList.
				 */
				for (int i=0; i < mCursor.getCount(); i++) {
					mApp.getService().getPlaybackIndecesList().add(mApp.getService().getCursor().getCount() + i);
				}
				
			}
			
			mApp.getService().enqueueCursor(mCursor, mPlayNext);
			
		} else {
			//The service doesn't seem to be running. We'll explicitly stop it, just in case, and then launch NowPlayingActivity.class.
			Intent serviceIntent = new Intent(mContext, AudioPlaybackService.class);
			mContext.stopService(serviceIntent);
			
			publishProgress(new Integer[] {0});
		}
		
		publishProgress(new Integer[] {1});
		
    	return true;
    }

