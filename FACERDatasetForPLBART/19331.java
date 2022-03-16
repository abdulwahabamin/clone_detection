    @Override
    public void onStart() {
    	super.onStart();
    	//Initialize the broadcast manager that will listen for track changes.
    	LocalBroadcastManager.getInstance(mContext)
		 					 .registerReceiver((mReceiver), new IntentFilter(Common.UPDATE_UI_BROADCAST));
    	
    	/* Check if the service is up and running. If so, send out a broadcast message 
    	 * that will initialize this activity fully. This code block is what will 
    	 * initialize this activity fully if it is opened after the service is already 
    	 * up and running (the onServiceRunning() callback isn't available at this point).
    	 */
    	if (mApp.isServiceRunning() && mApp.getService().getCursor()!=null) {
    		String[] updateFlags = new String[] { Common.UPDATE_PAGER_POSTIION, 
    											  Common.UPDATE_SEEKBAR_DURATION, 
    											  Common.HIDE_STREAMING_BAR, 
    											  Common.INIT_PAGER, 
    											  Common.UPDATE_PLAYBACK_CONTROLS, 
    											  Common.UPDATE_EQ_FRAGMENT };
    		
        	String[] flagValues = new String[] { "" + mApp.getService().getCurrentSongIndex(), 
        										 "" + mApp.getService().getCurrentMediaPlayer().getDuration(), 
        										 "", "", "", "" };
        	mApp.broadcastUpdateUICommand(updateFlags, flagValues);
    	}
    	
    }

