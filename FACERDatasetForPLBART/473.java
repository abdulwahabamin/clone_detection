        @Override
        public void discoverDevice(BluetoothDevice bluetoothDevice) {
            if (!mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
                mDeviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
                mBluetoothDevices.add(bluetoothDevice);
                mAdapter.setListAll(mBluetoothDevices);
            }
        }

