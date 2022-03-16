        public SendReceive(BluetoothSocket socket){

            // socket'i atadık.
            bluetoothSocket = socket;

            // tempInput null değeri
            InputStream tempInput = null;

            // tempOutput null değeri
            OutputStream tempOutput = null;

            try {
                // tempInput getInputStream metodu
                tempInput = bluetoothSocket.getInputStream();

                // tempOutput getOutputStream metodu
                tempOutput = bluetoothSocket.getOutputStream();

            } catch (IOException e) {
                e.printStackTrace();
            }

            // inputStream değerine tempInput değerini ata
            inputStream = tempInput;

            // outputStream değerine tempOutput değerini ata
            outputStream = tempOutput;
        }

