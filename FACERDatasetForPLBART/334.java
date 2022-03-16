    public void cancel(){
        try{
            bluetoothSocket.close();
        }catch (Exception e3){
            Toast.makeText(context,"Impossible de fermer le bs",Toast.LENGTH_SHORT).show();
        }
    }

