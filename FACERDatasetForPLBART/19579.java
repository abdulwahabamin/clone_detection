    @Override
    public void onDestroy() {
    	super.onDestroy();
    	LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    	
    }

