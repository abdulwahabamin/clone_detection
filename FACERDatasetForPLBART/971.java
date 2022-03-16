	@Override
	protected void onStart() {
		// ¿ªÆôºóÌ¨service
		Intent startService = new Intent(ServerActivity.this,
				BluetoothServerService.class);
		startService(startService);

		// ×¢²áBoradcasrReceiver
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(BluetoothTools.ACTION_DATA_TO_GAME);
		intentFilter.addAction(BluetoothTools.ACTION_CONNECT_SUCCESS);
		intentFilter.addAction(BluetoothTools.ACTION_CONNECT_ERROR);
		registerReceiver(broadcastReceiver, intentFilter);
		super.onStart();
	}

