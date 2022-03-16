        public void write(byte[] buffer) {
            try {
                mmOutStream.write(buffer);

               
                mHandler.obtainMessage(BluetoothChat.MESSAGE_WRITE, -1, -1, buffer)
                        .sendToTarget();
            } catch (IOException e) {
      
            }
        }

