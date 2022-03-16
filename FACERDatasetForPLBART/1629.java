	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BluetoothAdapter mBA = BluetoothAdapter.getDefaultAdapter();
		if (mBA == null) {
			Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
			finish();
		}
	}

