	@Override
	protected void onDestroy() {
		unregisterReceiver(broadcastReceiver);
		Debug.stopMethodTracing();
		super.onDestroy();
	}

