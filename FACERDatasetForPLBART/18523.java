	@Override
	public void onStart() {
	    super.onStart();
	    LocalBroadcastManager.getInstance(getActivity().getApplicationContext())
	    					 .registerReceiver((receiver), new IntentFilter("com.aniruddhc.acemusic.player.UPDATE_NOW_PLAYING"));
	
	}

