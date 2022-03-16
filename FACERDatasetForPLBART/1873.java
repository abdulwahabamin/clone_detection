        public ConnectedThread(BluetoothSocket socket) {

            Utils.log("new connected thread with new socket");
            mmSocket = socket;
            close=false;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            // Get the input and output streams; using temp objects because
            // member streams are final.
            try {
                tmpIn = socket.getInputStream();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred when creating input stream", e);
                close=true;
            }
            try {
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred when creating output stream", e);
                close=true;
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

