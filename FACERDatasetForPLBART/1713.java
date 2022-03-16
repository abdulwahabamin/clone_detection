        public void run() {
      
            byte[] buffer = new byte[1024];
            int bytes;

           
            while (true) {
                try {
                   
                    bytes = mmInStream.read(buffer);

                    
                    mHandler.obtainMessage(BluetoothChat.MESSAGE_READ, bytes, -1, buffer)
                            .sendToTarget();
                } catch (IOException e) {
           
                    connectionLost();
                    break;
                }
            }
        }

