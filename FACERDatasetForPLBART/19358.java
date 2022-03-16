    @Override
    public void onDestroy() {
    	super.onDestroy();
    	
    	if (mHandler!=null) {
        	mHandler.removeCallbacks(progressBarRunnable);
        	mHandler = null;
    	}

    	nowPlayingQueueFragment = null;
    	sharedPreferences.edit().putBoolean("NOW_PLAYING_QUEUE_VISIBLE", false).commit();
    	
    }

