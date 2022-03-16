        public void run() {
            // Cancel discovery as it will slow down the connection
            bluetoothAdapter.cancelDiscovery();

            try {
                // This will block until it succeeds in connecting to the device
                // through the bluetoothSocket or throws an exception
                bluetoothSocket.connect();
            }
            catch (IOException connectException) {
                connectException.printStackTrace();
                try {
                    bluetoothSocket.close();
                }
                catch (IOException closeException) {
                    closeException.printStackTrace();
                }
            }
            startNew(bluetoothDevice,bluetoothSocket);

            // Code to manage the connection in a separate thread
            /*
               manageBluetoothConnection(bluetoothSocket);
            */
        }

