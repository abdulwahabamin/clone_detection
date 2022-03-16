    public void cancel(){
        try{
            serverSocket.close();
        }catch (IOException e2){
            Log.v("ERREUR","Serveur non éteint");
        }
    }

