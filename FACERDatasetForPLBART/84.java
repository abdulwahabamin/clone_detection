	/**
	 * list的点击事件
	 */
	public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
		bluetoothAdapter.cancelDiscovery();

		NameAndAddress naa = (NameAndAddress) av.getItemAtPosition(arg2);
		String address = naa.address;

		if (address != null) {
			Intent intent = new Intent(this, LanylActivity.class);
			intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
			startActivity(intent);
		}
	}

