    public synchronized void connect(BluetoothDevice device) {
     

      
        if (mState == STATE_CONNECTING) {
            if (mConnectThread != null) {mConnectThread.cancel(); mConnectThread = null;}
        }

        
        if (mConnectedThread != null) {mConnectedThread.cancel(); mConnectedThread = null;}

       
        mConnectThread = new ConnectThread(device);
        mConnectThread.start();
        setState(STATE_CONNECTING);
    }

