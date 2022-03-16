	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_bluetooth_client_conn);
				
		TextView info =(TextView) findViewById(R.id.runAs);
		info.setText("Click the Bluetooth connection to join");
		mBA = BluetoothAdapter.getDefaultAdapter();
		
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter);
	}

