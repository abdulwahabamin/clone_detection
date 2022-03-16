    /**
     *
     *****************************
     * Bluetooth LE Specific code.
    /**
     * Starts BLE Advertisement
     */

    private void startScanning(){
        Intent scanningIntent = new Intent(getActivity(), BLEDiscoveringActivity.class);
        startActivityForResult(scanningIntent, BLE_REQUEST_CONNECT_DEVICE);
    }

