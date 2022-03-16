    @Override
    public void onResume(){
        super.onResume();
        //Inicia el socket server
        serverThread = new ServerThread(bluetoothAdapter);
        serverThread.start();
    }

