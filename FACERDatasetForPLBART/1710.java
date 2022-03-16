        public void run() {
       
            setName("ConnectThread");

           
            mAdapter.cancelDiscovery();

            
            try {
              
                mmSocket.connect();
            } catch (IOException e) {
                connectionFailed();
               
                try {
                    mmSocket.close();
                } catch (IOException e2) {
             
                }
               
                BluetoothChatService.this.start();
                return;
            }

          
            synchronized (BluetoothChatService.this) {
                mConnectThread = null;
            }

        
            connected(mmSocket, mmDevice);
        }

