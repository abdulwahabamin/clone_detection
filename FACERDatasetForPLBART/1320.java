    /**
     * Will try to connect to a RFCOMMSocket previously announced by the Peripheral device
     * WARNING: This is just a test. It may fail...
     *
     *
     */
    private void connect2RfcommSocket(){
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        mContext.registerReceiver(mReceiver, filter);
        // Register for broadcasts when discovery has finished
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        mContext.registerReceiver(mReceiver, filter);
        mBluetoothAdapter.startDiscovery();

    }

