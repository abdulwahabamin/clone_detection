	private void doDiscovery() {
		searchNewProgress.setVisibility(View.VISIBLE);
		searchNewButton.setEnabled(false);
		newDevicesArrayAdapter.clear();
		foundDevice.clear();
		/*//
		if (bluetoothAdapter.isDiscovering()) {
			bluetoothAdapter.cancelDiscovery();
		}*/
		//
		bluetoothAdapter.startDiscovery();
	}

