        public ConnectedThread(BluetoothSocket socket) {
       
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

           
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
        
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

