    public void startAccept(final BluetoothAdapter bluetoothAdapter) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BluetoothServerSocket serverSocket
                            = bluetoothAdapter.listenUsingRfcommWithServiceRecord("chat-server", UUID.fromString(serverUuid));

                    mSocket = serverSocket.accept();

                    mSocket.getRemoteDevice();

                    mOutputStream = mSocket.getOutputStream();

                    mInputStream = mSocket.getInputStream();

                    crateReadThread();

                    Message msg=mainHandler.obtainMessage();

                    msg.what=CONNECTED_SUCCESS;

                    msg.obj=mSocket.getRemoteDevice();

                    mainHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "client connect error:" + e.getMessage());
                    mainHandler.sendEmptyMessage(CONNECTED_FAIL);
                }

            }
        }).start();
    }

