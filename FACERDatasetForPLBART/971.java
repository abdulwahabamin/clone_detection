	@Override
	protected void onStart() {
		// ������̨service
		Intent startService = new Intent(ServerActivity.this,
				BluetoothServerService.class);
		startService(startService);

		// ע��BoradcasrReceiver
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(BluetoothTools.ACTION_DATA_TO_GAME);
		intentFilter.addAction(BluetoothTools.ACTION_CONNECT_SUCCESS);
		intentFilter.addAction(BluetoothTools.ACTION_CONNECT_ERROR);
		registerReceiver(broadcastReceiver, intentFilter);
		super.onStart();
	}

