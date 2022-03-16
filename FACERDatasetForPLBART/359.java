    public ManageConnectionThread(BluetoothSocket socket, Context c, Handler handler){
        context=c;
        mSocket=socket;
        mhandler=handler;
        InputStream tmpinputStream=null;
        OutputStream tmpoutStream=null;

        try{
            tmpinputStream=mSocket.getInputStream();
        }catch (Exception e1){
            Toast.makeText(c,"Flux d'entrée non récupéré",Toast.LENGTH_SHORT).show();
        }
        try{
            tmpoutStream=mSocket.getOutputStream();
        }catch (Exception e2){
            Toast.makeText(c,"Flux de sortie non récupéré",Toast.LENGTH_SHORT).show();
        }
        inputStream=tmpinputStream;
        outputStream=tmpoutStream;
    }

