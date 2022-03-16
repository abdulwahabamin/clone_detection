    /**
     * 是�?�支�?BLE
     */
    private boolean isSupportBLE() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        BluetoothManager manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = manager.getAdapter();
        //设备是�?�支�?�?牙
        if (mBluetoothAdapter != null
                //系统是�?�支�?BLE
                && getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Log.i(TAG, " support bluetooth");
            return true;
        } else {
            Log.i(TAG, "not support bluetooth");
            return false;
        }

    }

