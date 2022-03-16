    public void cancel(){
        try{
            bluetoothSocket.close();
            if(commsThread != null){
                commsThread.cancel();
            }
        } catch (IOException e){
            Log.d("ConnectToServerThread", e.getLocalizedMessage());
        }
    }

