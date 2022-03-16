	@Override
	public void onStop() {
		super.onStop();
		
		//Unregister the broadcast receivers.
    	LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mReceiver);
	
	}

