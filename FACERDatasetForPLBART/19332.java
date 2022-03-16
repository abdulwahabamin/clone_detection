    @Override
    public void onStop() {
    	//Unregister the broadcast receivers.
    	LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mReceiver);
    	super.onStop();
    	
    }

