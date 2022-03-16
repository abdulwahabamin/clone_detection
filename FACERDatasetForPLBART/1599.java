    public void run(){
        // Cancelar el proceso de búsqueda porque ralentiza la conexión
        bluetoothAdapter.cancelDiscovery();
        try {
            //Utilizar el socket para conectar el dispositivo. Estará bloqueado hasta que se complete
            //con éxito o surja una excepción.
            bluetoothSocket.connect();

            // Crear el hilo de ejecución para el canal de comunicación.
            commsThread = new CommsThread(bluetoothSocket);
            commsThread.start();
        } catch (IOException connectException){
            // SI no es capaz de establecer la conexión se cierra el socket y se abandona
            try{
                bluetoothSocket.close();
            } catch (IOException closeException){
                closeException.getLocalizedMessage();
            }
            return;
        }
    }

