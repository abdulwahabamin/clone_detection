    private void initView() {
        lv = findViewById(R.id.lvBLE);


        deviceList = new ArrayList<>();

        deviceAdapter = new BLEAdapter(this, deviceList);

        lv.setAdapter(deviceAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDevice device = deviceList.get(position);

                bluetoothGatt = device.connectGatt(MainActivity.this, true, gattCallback);
            }
        });

        gattCallback = new GattCallback(handler);
    }

