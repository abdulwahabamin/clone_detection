    public void write(String text) {

        if (mSocket != null) {
            if (!mSocket.isConnected()) {
                mainHandler.sendEmptyMessage(ClientService.BLUETOOTH_SOCKET_CLOSED);
                Log.i(TAG, "write fail when socket was closed");
                return;
            }
        }

        Message msg = mainHandler.obtainMessage();
        String data = text;
        if (mOutputStream != null) {
            try {
                mOutputStream.write(text.getBytes());

                mOutputStream.flush();
                msg.what = WRITE_DATA_SUCCESS;
            } catch (IOException e) {
                e.printStackTrace();
                data = e.getMessage();
                msg.what = WRITE_DATA_FAIL;
            }
        }

        msg.obj = data;

        mainHandler.sendMessage(msg);
    }

