	private void updateDeviceList() {
		Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

		if (pairedDevices.size() > 0) {
			findViewById(R.id.page_devicelist_title_yipeiduitextview).setVisibility(View.VISIBLE);
			for (BluetoothDevice device : pairedDevices) {
				pairedDevicesArrayAdapter.add(new NameAndAddress(device.getName(), device.getAddress()));
			}
		} else {
			String noDevices = getResources().getText(R.string.none_paired).toString();
			pairedDevicesArrayAdapter.add(new NameAndAddress(noDevices, null));
		}
	}

