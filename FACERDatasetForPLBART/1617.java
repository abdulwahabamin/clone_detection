	public void selectedPaired(View v){
		ProgressBar progress = (ProgressBar) findViewById(R.id.searching);
		progress.setVisibility(View.VISIBLE);
		pairedDevices = new ArrayList<BluetoothDevice>(); 
		pairedDevices.addAll(mBA.getBondedDevices());
		allDevices = new ArrayList<String>();
		for(BluetoothDevice device : pairedDevices){
			allDevices.add(device.getName());
		}
		ListView devicesList = (ListView)findViewById(R.id.devicesList);
		ArrayAdapter<String> list = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,allDevices);
		devicesList.setAdapter(list);
		devicesList.setOnItemClickListener(setupClient);
		progress.setVisibility(View.GONE);
	}

