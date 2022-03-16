    public synchronized void connected(BluetoothSocket socket, BluetoothDevice device) {
     

        
        if (mConnectThread != null) {mConnectThread.cancel(); mConnectThread = null;}

     
        if (mConnectedThread != null) {mConnectedThread.cancel(); mConnectedThread = null;}

        
        if (mAcceptThread != null) {mAcceptThread.cancel(); mAcceptThread = null;}

     
        mConnectedThread = new ConnectedThread(socket);
        mConnectedThread.start();

        
        Message msg = mHandler.obtainMessage(BluetoothChat.MESSAGE_DEVICE_NAME);
        Bundle bundle = new Bundle();
        bundle.putString(BluetoothChat.DEVICE_NAME, device.getName());
        msg.setData(bundle);
        mHandler.sendMessage(msg);

        setState(STATE_CONNECTED);
    }

