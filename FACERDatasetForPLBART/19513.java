    /**
     * Applies the specified repeat mode.
     */
    public void setRepeatMode(int repeatMode) {
    	if (repeatMode==Common.REPEAT_OFF || repeatMode==Common.REPEAT_PLAYLIST ||
    		repeatMode==Common.REPEAT_SONG || repeatMode==Common.A_B_REPEAT) {
    		//Save the repeat mode.
    		mApp.getSharedPreferences().edit().putInt(Common.REPEAT_MODE, repeatMode).commit();
    	} else {
    		//Just in case a bogus value is passed in.
    		mApp.getSharedPreferences().edit().putInt(Common.REPEAT_MODE, Common.REPEAT_OFF).commit();
    	}
    	
    	/* 
    	 * Set the both MediaPlayer objects to loop if the repeat mode 
    	 * is Common.REPEAT_SONG.
    	 */
    	try {
    		if (repeatMode==Common.REPEAT_SONG) {
    			getMediaPlayer().setLooping(true);
    			getMediaPlayer2().setLooping(true);
    		} else {
    			getMediaPlayer().setLooping(false);
    			getMediaPlayer2().setLooping(false);
    		}
    		
    		//Prepare the appropriate next song.
    		prepareAlternateMediaPlayer();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

        /*
         * Remove the crossfade callbacks and reinitalize them
         * only if the user didn't select A-B repeat.
         */
        clearCrossfadeCallbacks();

        if (repeatMode!=Common.A_B_REPEAT)
            if (mHandler!=null && mApp.isCrossfadeEnabled())
                mHandler.post(startCrossFadeRunnable);
    	
    }

