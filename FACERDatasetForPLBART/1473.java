    private void tryToConnect(BluetoothDevice device){
        mBtAdapter.cancelDiscovery();
        // Get the device MAC address, which is the last 17 chars in the View
        String address = device.getAddress();
        // Create the result Intent and include the MAC address
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
        // Set result and finish this Activity
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

