    public ConnectedAsServerThread(BluetoothAdapter bluetoothAdapter, Context c, Application app){
        context=c;
        application=app;
        BluetoothServerSocket tmp=null;
        try{
            tmp=bluetoothAdapter.listenUsingRfcommWithServiceRecord("BluetoothTry",mUUID);
        }catch (IOException e){}
        serverSocket=tmp;
    }

