    public void cancel(){
        try{
            mSocket.close();
        }catch (IOException ioe){
            Toast.makeText(context,"On n'a pas pu fermer le canal",Toast.LENGTH_SHORT).show();
        }
    }

