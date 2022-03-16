    @Override
    public void onPause(){
        super.onPause();
        //Cancela la búsqueda de otros dispositivos Bluetooth.
        bluetoothAdapter.cancelDiscovery();

        //Elimina el registro del receptor de difusión dedicado a la búsqueda de dispositivos.
        if(discoverDevicesReceiver != null){
            try{
                unregisterReceiver(discoverDevicesReceiver);
            } catch (Exception e){
            }
        }
        //Si estamos conectados a alguien, entonces...
        if(connectToServerThread != null){
            try{
                //Cerramos la conexión
                connectToServerThread.bluetoothSocket.close();
            } catch (IOException e){
                Log.d("MainActivity", e.getLocalizedMessage());
            }
        }
        //Se detiene el hilo de ejecución.
        if(serverThread != null){
            serverThread.cancel();
        }
    }

