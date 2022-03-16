    public void run(){
        BluetoothSocket socket = null;

        // Se sigue escuchando hasta que tenga lugar una excepción o se devuelva un socket.
        while (true){
            try {
                socket = bluetoothServerSocket.accept();
            } catch (IOException e){
                Log.d("ServerThread", e.getLocalizedMessage());
                break;
            }
            // Si se acepta una conexión.
            if(socket != null){
                // Se crea un hilo de ejecución independiente para escuchar los datos entrantes.
                CommsThread commsThread = new CommsThread(socket);
                commsThread.run();
            }
        }
    }

