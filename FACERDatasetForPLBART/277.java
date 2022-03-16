    /**
     * æ˜¯å?¦æ”¯æŒ?BLE
     */
    private boolean isSupportBLE() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        BluetoothManager manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = manager.getAdapter();
        //è®¾å¤‡æ˜¯å?¦æ”¯æŒ?è“?ç‰™
        if (mBluetoothAdapter != null
                //ç³»ç»Ÿæ˜¯å?¦æ”¯æŒ?BLE
                && getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Log.i(TAG, " support bluetooth");
            return true;
        } else {
            Log.i(TAG, "not support bluetooth");
            return false;
        }

    }

