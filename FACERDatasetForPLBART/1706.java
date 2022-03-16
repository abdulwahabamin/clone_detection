        public AcceptThread() {
            BluetoothServerSocket tmp = null;

           
            try {
                tmp = mAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            } catch (IOException e) {
        
            }
            mmServerSocket = tmp;
        }

