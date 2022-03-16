        public void cancel() {
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
            }
        }

