    @Override
    public void onPause() {
    	super.onPause();
    	
    	if (mHandler!=null) {
        	mHandler.removeCallbacks(progressBarRunnable);
        	mHandler = null;
    	}
    	
    	if (this.isRemoving()) {
    		if (mCursor!=null) {
    			mCursor.close();
    			mCursor = null;
    		}
    		
    	}
    	
    	nowPlayingQueueFragment = null;
    	sharedPreferences.edit().putBoolean("NOW_PLAYING_QUEUE_VISIBLE", false).commit();
    	
    }

