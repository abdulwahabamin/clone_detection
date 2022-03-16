	@Override
	public void onStart() {
	    super.onStart();
	    LocalBroadcastManager.getInstance(mContext)
	    					 .registerReceiver((receiver), new IntentFilter(Common.UPDATE_UI_BROADCAST));
	
	}

