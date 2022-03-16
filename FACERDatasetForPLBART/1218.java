        public ConnectThread(BluetoothDevice device) {
            BluetoothSocket tmp = null;

            try {
                tmp = device.createRfcommSocketToServiceRecord(
                        java.util.UUID.fromString(MainActivity.UUID));
            } catch (Exception e) {
                System.err.println("Failed to connect");
                System.err.println(e.toString());
            }

            mmSocket = tmp;
        }

