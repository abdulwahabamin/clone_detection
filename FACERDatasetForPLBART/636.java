    public synchronized void connect(BluetoothDevice device, boolean secure) {
        BleLog.d("connect to: " + device);
        if (mState == State.STATE_CONNECTING) {
            if (mConnectThread != null) {
                mConnectThread.cancel();
                mConnectThread = null;
            }
        }

        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        mConnectThread = new ConnectThread(this, device, secure);
        mConnectThread.start();
        setState(State.STATE_CONNECTING);
    }

