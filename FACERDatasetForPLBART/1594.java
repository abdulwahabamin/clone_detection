    public CommsThread(BluetoothSocket socket){
        bluetoothSocket = socket;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;
        try {
            // Creamos los objetos InputStream y OutputStream.
            // Son necesarios para leer y escribir a través de los Socket.
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();

        } catch (IOException e){
            Log.d("CommsThread", e.getLocalizedMessage());
        }
        inputStream = tmpIn;
        outputStream = tmpOut;
    }

