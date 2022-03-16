	@Override
	public void onStop() {
	    LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).unregisterReceiver(receiver);
	    super.onStop();
	    
	}

