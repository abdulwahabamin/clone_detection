    public synchronized void connected(BluetoothSocket socket,
                                       BluetoothDevice device, final String socketType) {
        BleLog.d("connected, Socket Type:" + socketType);
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        if (mAcceptThread != null){
            mAcceptThread.cancel();
            mAcceptThread = null;
        }

        mConnectedThread = new ConnectedThread(this, socket, socketType);
        mConnectedThread.start();

        mHandler.obtainMessage(ChatConstant.MESSAGE_DEVICE_NAME, -1, -1, device.getName()).sendToTarget();
        setState(State.STATE_CONNECTED);
    }

