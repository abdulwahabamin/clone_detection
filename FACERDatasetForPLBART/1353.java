    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_discovering);


        ListView newDevicesListView = (ListView) findViewById(R.id.bleDevicesFound);
        mNewDevicesArrayAdapter = new ArrayAdapter<BLEDevice>(this, R.layout.device_name);
        newDevicesListView.setAdapter(mNewDevicesArrayAdapter);
        newDevicesListView.setOnItemClickListener(mDeviceClickListener);

        mBleChat.init(this, mBleDiscoverCallback);
    }

