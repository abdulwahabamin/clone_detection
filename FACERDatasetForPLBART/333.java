    @Override
    public void run() {
        //On doit faire le cancelDiscovery dans le main
        bAdapter.cancelDiscovery();
        try{
            bluetoothSocket.connect();
        }catch (IOException e2){
            try{
                bluetoothSocket.close();
            }catch (Exception e3){
                Toast.makeText(context,"Impossible de fermer le bs",Toast.LENGTH_SHORT).show();
            }
            return ;
        }
        ((MyApplication)application).setClientSocket(bluetoothSocket);
        Intent intent1=new Intent(context,GoActivity.class);
        intent1.putExtra("statut","client");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent1);
    }

