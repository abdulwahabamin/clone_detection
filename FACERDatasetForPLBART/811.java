        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                scanDevicesList.add(new BlueToothDeviceModel(device));
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                if (llBottomButtons.getVisibility()==View.GONE)llBottomButtons.setVisibility(View.VISIBLE);
                tvScanTitle.setText("Scan Finished");
                tvScanDevices.setEnabled(true);
                if (scanDevicesList.size() == 0) {
                    Toast.makeText(context, "ZERO", Toast.LENGTH_SHORT).show();
                    if (tvEmpty.getVisibility()==View.GONE)tvEmpty.setVisibility(View.VISIBLE);
                }else{
                    CustomAdapterScan adapterScan = new CustomAdapterScan(scanDevicesList,MainActivity.this);
                    lvScan.setAdapter(adapterScan);
                }

            }
        }

