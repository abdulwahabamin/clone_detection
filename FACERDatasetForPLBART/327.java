        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // If it's already paired, skip it, because it's been listed already
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    discoveredDevicesAdapter.add(device.getName() + "\n" + device.getAddress());
                }
                // When discovery is finished, change the Activity title
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                discoveredDevicesAdapter.clear();
                setProgressBarIndeterminateVisibility(false);
                setTitle("Select a device to connect");
                if (discoveredDevicesAdapter.getCount() == 0) {

                    discoveredDevicesAdapter.add("No devices found");
                }
            }
            else
            {
                discoveredDevicesAdapter.add("Scanning Bluetooth Devices....");
            }
        }

