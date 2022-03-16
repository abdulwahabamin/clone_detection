    private void bindEventHandler() {
        lvDeviceListPairedDevice.setOnItemClickListener(mDeviceClickListener);
        lvDeviceListNewDevice.setOnItemClickListener(mDeviceClickListener);

        btnDeviceListScan.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startDiscovery();
                btnDeviceListScan.setVisibility(View.GONE);
            }
        });
    }

