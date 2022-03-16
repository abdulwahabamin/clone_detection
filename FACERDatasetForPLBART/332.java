    public ConnectedAsClientThread(BluetoothDevice device, Context c, BluetoothAdapter bA, Application app){
        bAdapter=bA;
        CDevice=device;
        context=c;
        application=app;
        BluetoothSocket tmp=null;

        try{
            tmp=device.createRfcommSocketToServiceRecord(mUUID);
        }catch (IOException e1){
            Toast.makeText(context,"Socket non créé",Toast.LENGTH_SHORT).show();
        }
        bluetoothSocket=tmp;
    }

