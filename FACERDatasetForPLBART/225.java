    public void connect(final BluetoothDevice connectDevice, final String uuid) {

        if (device != null && mSocket != null && device.getAddress().equals(device.getAddress()) && mSocket.isConnected()) {

            Log.i(TAG, "the same device to connect,return");

            return;
        }

        this.device = connectDevice;

        Log.i(TAG, "device:" + device.getName());

        Log.i(TAG, "uuid:" + uuid);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(uuid));

                    mSocket.connect();

                    mOutputStream = mSocket.getOutputStream();

                    mInputStream = mSocket.getInputStream();

                    crateReadThread();

                    mainHandler.sendEmptyMessage(CONNECTED_SUCCESS);

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "client connect error:" + e.getMessage());
                    mainHandler.sendEmptyMessage(CONNECTED_FAIL);
                }

            }
        }).start();
    }

