    public AcceptThread() {
        // Use a temporary object that is later assigned to mmServerSocket
        // because mmServerSocket is final.


        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothServerSocket tmp = null;
        Log.e(TAG, "create : trying to get socket");
        try {
            // MY_UUID is the app's UUID string, also used by the client code.
            Log.e(TAG, "create : here 2");
            tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            Log.e(TAG, "create : here 3 " + tmp);
        } catch (IOException e) {
            Log.e(TAG, "create : Socket's listen method failed", e);
            Log.e(TAG, "Socket's listen() method failed", e);
        }
        mmServerSocket = tmp;
        Log.e(TAG, "create : here 4");
    }

