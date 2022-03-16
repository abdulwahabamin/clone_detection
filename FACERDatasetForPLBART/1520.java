    public void startNew(BluetoothDevice device, BluetoothSocket socket){
        mBluetoothDevice = device;
        mBluetoothSocket = socket;
        Intent intent = new Intent(getApplicationContext(),DataTransfer.class);
        startActivity(intent);
    }

