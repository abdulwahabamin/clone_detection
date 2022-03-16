	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_devicelist);

		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter == null) {
			Toast.makeText(this, R.string.lanyanotvalid, Toast.LENGTH_LONG).show();
			finish();
			return;
		}
		
		pairedDevicesArrayAdapter = new ArrayAdapter<NameAndAddress>(this, R.layout.listitem_deviceinfo);
		newDevicesArrayAdapter = new ArrayAdapter<NameAndAddress>(this, R.layout.listitem_deviceinfo);

		ListView pairedListView = (ListView) findViewById(R.id.page_devicelist_paireddevices);
		pairedListView.setAdapter(pairedDevicesArrayAdapter);
		pairedListView.setOnItemClickListener(this);

		ListView newDevicesListView = (ListView) findViewById(R.id.page_devicelist_newdevices);
		newDevicesListView.setAdapter(newDevicesArrayAdapter);
		newDevicesListView.setOnItemClickListener(this);

		searchNewProgress = (ProgressBar)findViewById(R.id.devicelist_progressbar);
		searchNewButton = (ImageButton)findViewById(R.id.page_devicelist_search);
		
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(mReceiver, filter);

		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(mReceiver, filter);
		//
		if (!bluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
		} else {
			updateDeviceList();
		}
	}

