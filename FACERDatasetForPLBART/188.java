    private void isSupportBle() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        BluetoothManager manager= (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter= manager.getAdapter();

        if (mBluetoothAdapter == null
                || !getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)) {
            showNotSupportBluetoothDialog();
            Log.e(TAG, "not support bluetooth");
        } else {
            Log.e(TAG, " support bluetooth");

        }
    }

