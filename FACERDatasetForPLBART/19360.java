	@Override
	public void onStop() {
	    LocalBroadcastManager.getInstance(mContext).unregisterReceiver(receiver);
	    super.onStop();
	    
	}

