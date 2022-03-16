    private void btDeviceConnected(BluetoothDevice bluetoothDevice) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> connectedBtDevices = sharedPreferences.getStringSet(Constants.CONNECTED_BT_DEVICES, new HashSet<String>());
        if (!connectedBtDevices.contains(bluetoothDevice.getAddress())) {
            connectedBtDevices.add(bluetoothDevice.getAddress());
            sharedPreferences.edit().putStringSet(Constants.CONNECTED_BT_DEVICES, connectedBtDevices).apply();
        }
        if (isBtTriggerEnabled(bluetoothDevice)) {
            timerHandler.postDelayed(timerRunnable, 15000);
        }
    }

