    public void run() {
        BluetoothSocket socket = null;
        EventBus.getDefault().post(new ChatStatusEvent(Constants.STATUS_LISTENING,macAddress));
        // Keep listening until exception occurs or a socket is returned.
        while (true) {
            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                Log.e(TAG, "Socket's accept() method failed", e);
                EventBus.getDefault().post(new ChatStatusEvent(Constants.STATUS_LISTENING_FAILED,macAddress));
                cancel();
                break;
            }

            if (socket != null) {
                // A connection was accepted. Perform work associated with
                // the connection in a separate thread.
                manageMyConnectedSocket(socket);

                cancel();
                break;
            }
        }
    }

