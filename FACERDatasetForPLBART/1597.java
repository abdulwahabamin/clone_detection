    public void cancel(){
        try{
            bluetoothSocket.close();
        } catch (IOException e){
            Log.d("CommsThread", e.getLocalizedMessage());
        }
    }

