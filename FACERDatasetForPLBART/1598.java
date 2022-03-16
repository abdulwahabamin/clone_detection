    public ConnectToServerThread(BluetoothDevice device, BluetoothAdapter btAdapter){

        BluetoothSocket tmp = null;
        bluetoothAdapter = btAdapter;
        //Se obtiene un objeto BluetoothSocket para conectar con el dispositivo Bluetooth.
        try {
            // EL identificador UUID debe ser el mismo en el cliente y en el servidor.
            tmp = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString(MainActivity.UUID));
        } catch (IOException e){
            Log.d("ConnectToServerThread", e.getLocalizedMessage());
        }
        bluetoothSocket = tmp;
    }

