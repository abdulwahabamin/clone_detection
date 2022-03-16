        public AcceptThread(boolean secure) {
            BluetoothServerSocket tmp = null;
            socketType = secure ? "Secure" : "Insecure";

            try {
                if (secure) {
                    tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord(
                            NAME_SECURE, MY_UUID_SECURE);
                } else {
                    tmp = bluetoothAdapter
                            .listenUsingInsecureRfcommWithServiceRecord(
                                    NAME_INSECURE, MY_UUID_INSECURE);
                }
            } catch (IOException e) {
            }
            serverSocket = tmp;
        }

