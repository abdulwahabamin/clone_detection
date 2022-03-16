    public ConnectThread(BluetoothDevice device, UUID myUuid) {
        // Use a temporary object that is later assigned to mmSocket
        // because mmSocket is final.
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothSocket tmp = null;
        mmDevice = device;

        try {
            // Get a BluetoothSocket to connect with the given BluetoothDevice.
            // MY_UUID is the app's UUID string, also used in the server code.
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);

        } catch (IOException e) {
            Log.e(TAG, "pair : Socket's create() method failed", e);
        }
        mmSocket = tmp;
    }

