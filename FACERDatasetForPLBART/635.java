    public synchronized void start(boolean secure) {
        BleLog.d("server start");
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        setState(State.STATE_LISTEN);

        if (mAcceptThread == null) {
            if(secure){
                BleLog.d("mSecureAcceptThread start");
            } else{
                BleLog.d("mInsecureAcceptThread start");
            }
            mAcceptThread = new AcceptThread(this, secure);
            mAcceptThread.start();
        }
    }

