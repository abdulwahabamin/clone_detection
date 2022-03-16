    public void run(){
        //Buffer de almacenamiento para el Stream.
        byte[] buffer = new byte[1024];

        // Bytes procedentes de read()
        int bytes;

        // Se sigue escuchando InputStream hasta que tenga lugar una excepción
        while(true){
            try {
                // Lectura de InputStream
                bytes = inputStream.read(buffer);

                // Actualizar la interfaz de usuario de la actividad principal.
                MainActivity.UIupdater.obtainMessage(0, bytes, -1, buffer).sendToTarget();
            } catch (IOException e){
                Log.d("CommsThread", e.getLocalizedMessage());
                break;
            }
        }
    }

