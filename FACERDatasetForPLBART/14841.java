	@Override
	protected void onDestroy( ){
		stopService(playIntent);
		musicSRV = null;
		super.onDestroy();
	}

