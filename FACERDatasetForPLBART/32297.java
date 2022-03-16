    private void btDeviceDisConnected(BluetoothDevice bluetoothDevice) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> connectedBtDevices = sharedPreferences.getStringSet(Constants.CONNECTED_BT_DEVICES, new HashSet<String>());
        if (connectedBtDevices.contains(bluetoothDevice.getAddress())) {
            connectedBtDevices.remove(bluetoothDevice.getAddress());
            sharedPreferences.edit().putStringSet(Constants.CONNECTED_BT_DEVICES, connectedBtDevices).apply();
        }
    }

