    @Override
    public void onDestroy() {
    	super.onDestroy();
    	
/*    	NowPlayingQueueFragment nowPlayingQueueFragment = 
    	
    	if (nowPlayingQueueFragment.bm!=null) {
    		
        	if (!nowPlayingQueueFragment.bm.isRecycled()) {
        		nowPlayingQueueFragment.bm.recycle();
        	}
        	
    	}

    	nowPlayingQueueFragment.bm = null;
    	nowPlayingQueueFragment.embeddedArt = null;
    	nowPlayingQueueFragment.is = null;*/

    	overridePendingTransition(R.anim.scale_and_fade_in, R.anim.fade_out);
    	
    }

