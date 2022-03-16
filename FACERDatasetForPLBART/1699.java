    public synchronized void start() {
     

       
        if (mConnectThread != null) {mConnectThread.cancel(); mConnectThread = null;}

       
        if (mConnectedThread != null) {mConnectedThread.cancel(); mConnectedThread = null;}

      
        if (mAcceptThread == null) {
            mAcceptThread = new AcceptThread();
            mAcceptThread.start();
        }
        setState(STATE_LISTEN);
    }

