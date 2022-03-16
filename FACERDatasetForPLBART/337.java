    @Override
    public void run() {
        //Toast.makeText(context,"Dans le run du serveur",Toast.LENGTH_SHORT).show();
        while(true){
            try {
                socket=serverSocket.accept();
            }catch (IOException e1){
                break;
            }

            if(socket!=null){
                //Toast.makeText(context,"Le socket n'est pas null",Toast.LENGTH_SHORT).show();
                ((MyApplication)application).setServeurSocket(socket);
                Intent intent=new Intent(context,GoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("statut","serveur");
                application.startActivity(intent);
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

