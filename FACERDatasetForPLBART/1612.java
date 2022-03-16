    public ServerThread(BluetoothAdapter bluetoothAdapter){
        BluetoothServerSocket tmp = null;
        try {
            // Cliente y servidor con mismo UUID
            tmp = bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord("BluetoothApp", UUID.fromString(MainActivity.UUID));
        } catch (IOException e){
            Log.d("ServerThread", e.getLocalizedMessage());
        }
        bluetoothServerSocket = tmp;
    }

