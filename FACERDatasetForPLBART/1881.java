    public void run() {
        // Cancel discovery because it otherwise slows down the connection.
        BlueHelper.getBluetoothAdapter().cancelDiscovery();

        try {
            // Connect to the remote device through the socket. This call blocks
            // until it succeeds or throws an exception.
            EventBus.getDefault().post(new ChatStatusEvent(Constants.STATUS_CONNECTING,mmDevice.getAddress()));
            mmSocket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and return.
            EventBus.getDefault().post(new ChatStatusEvent(Constants.STATUS_CONNECTING_FAILED,mmDevice.getAddress()));
            cancel();

            return;
        }

        // The connection attempt succeeded. Perform work associated with
        // the connection in a separate thread.
        manageMyConnectedSocket(mmSocket);
    }

