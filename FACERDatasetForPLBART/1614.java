    public void cancel(){
        try {
            bluetoothServerSocket.close();
        } catch (IOException e){
            Log.d("ServerThread", e.getLocalizedMessage());
        }
    }

