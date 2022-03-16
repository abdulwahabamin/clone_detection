        public void run() {
            BluetoothSocket bluetoothSocket;
            // This will block while listening until a BluetoothSocket is returned
            // or an exception occurs
            while (true) {
                try {
                    bluetoothSocket = bluetoothServerSocket.accept();
                }
                catch (IOException e) {
                    break;
                }
                // If a connection is accepted
                if (bluetoothSocket != null) {

                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "A connection has been accepted.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    startNew(bluetoothSocket.getRemoteDevice(),bluetoothSocket);
                    try {
                        bluetoothServerSocket.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

