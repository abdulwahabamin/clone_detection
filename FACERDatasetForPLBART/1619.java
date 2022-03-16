	public void selectedSearch(View v){
		ProgressBar progress = (ProgressBar) findViewById(R.id.searching);
		progress.setVisibility(View.VISIBLE);
		pairedDevices = new ArrayList<BluetoothDevice>();
		mBA.startDiscovery();
		allDevices = new ArrayList<String>();
		ListView devicesList = (ListView)findViewById(R.id.devicesList);
		devicesList.setAdapter(null);
	}

