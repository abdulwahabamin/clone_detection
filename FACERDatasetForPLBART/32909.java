    public static boolean isBluetoothHeadsetEnabledConnected(Context context) {
        BluetoothAdapter bluetoothAdapter = Utils.getBluetoothAdapter(context);
        boolean isBtConnected = (bluetoothAdapter != null && (
                BluetoothProfile.STATE_CONNECTED == bluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEADSET) ||
                        BluetoothProfile.STATE_CONNECTED == bluetoothAdapter.getProfileConnectionState(BluetoothProfile.A2DP)));
        if (!isBtConnected) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (!sharedPreferences.getStringSet(Constants.CONNECTED_BT_DEVICES, new HashSet<String>()).isEmpty()) {
                sharedPreferences.edit().putStringSet(Constants.CONNECTED_BT_DEVICES, new HashSet<String>()).apply();
            }
        }
        return isBtConnected;
    }

