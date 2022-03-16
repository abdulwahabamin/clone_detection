    private void initView() {
        lvBle.setAdapter(bleAdapter);


        lvBle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mBluetoothAdapter.cancelDiscovery();

                selectedDevice = list.get(position);

                Intent intent = new Intent(MainActivity.this, DeviceActivity.class);

                intent.putExtra("device", selectedDevice);

                startActivity(intent);


            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothAdapter != null) {
                    list.clear();
                    mBluetoothAdapter.startDiscovery();
                }
            }
        });
    }

