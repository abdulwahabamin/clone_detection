    public void run() {
        BleLog.i("Socket Type: " + mSocketType + "BEGIN mAcceptThread" + this);
        setName("AcceptThread" + mSocketType);

        BluetoothSocket socket = null;

        while (mHelper.getState() != com.vise.basebluetooth.common.State.STATE_CONNECTED) {
            try {
                BleLog.i("wait new socket:" + mServerSocket);
                socket = mServerSocket.accept();
            } catch (IOException e) {
                BleLog.e("Socket Type: " + mSocketType + " accept() failed", e);
                break;
            }
            if (socket != null) {
                synchronized (this) {
                    if(mHelper.getState() == com.vise.basebluetooth.common.State.STATE_LISTEN
                            || mHelper.getState() == com.vise.basebluetooth.common.State.STATE_CONNECTING){
                        BleLog.i("mark CONNECTING");
                        mHelper.connected(socket, socket.getRemoteDevice(), mSocketType);
                    } else if(mHelper.getState() == com.vise.basebluetooth.common.State.STATE_NONE
                            || mHelper.getState() == com.vise.basebluetooth.common.State.STATE_CONNECTED){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            BleLog.e("Could not close unwanted socket", e);
                        }
                    }
                }
            }
        }
        BleLog.i("END mAcceptThread, socket Type: " + mSocketType);
    }

