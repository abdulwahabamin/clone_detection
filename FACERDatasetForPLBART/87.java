		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
					NameAndAddress naa = new NameAndAddress(device.getName(), device.getAddress());
					if(!foundDevice.contains(naa)) {
						newDevicesArrayAdapter.add(naa);
						foundDevice.add(naa);
					}
				}
			} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
				searchNewProgress.setVisibility(View.INVISIBLE);
				searchNewButton.setEnabled(true);
				
				if (newDevicesArrayAdapter.getCount() == 0) {
					String noDevices = getResources().getText(R.string.none_found).toString();
					newDevicesArrayAdapter.add(new NameAndAddress(noDevices, null));
				}
			}
		}

