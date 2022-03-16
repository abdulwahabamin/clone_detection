        public void run() {
            setName("AcceptThread");
            BluetoothSocket socket = null;

            while (state != STATE_CONNECTED) {
                if(serverSocket!=null){
                    try {
                        socket = serverSocket.accept();
                    } catch (IOException e) {
                        break;
                    } }else{
                    BluetoothServerSocket tmp = null;
                    try {
                        tmp = bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(APP_NAME, MY_UUID);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    serverSocket = tmp;
                }

                // If a connection was accepted
                if (socket != null) {
                    synchronized (ChatController.this) {
                        switch (state) {
                            case STATE_LISTEN:
                            case STATE_CONNECTING:
                                // start the connected thread.
                                connected(socket, socket.getRemoteDevice());
                                break;
                            case STATE_NONE:
                            case STATE_CONNECTED:
                                // Either not ready or already connected. Terminate
                                // new socket.
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                }
                                break;
                        }
                    }
                }

            }}

