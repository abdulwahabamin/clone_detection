	private boolean disableBluetooth() {
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter != null) {
			if (mBluetoothAdapter.isEnabled())
				return mBluetoothAdapter.disable();
		}
		return true;
	}

