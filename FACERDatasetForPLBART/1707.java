        public void run() {
     
            setName("AcceptThread");
            BluetoothSocket socket = null;

           
            while (mState != STATE_CONNECTED) {
                try {
                   
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
         
                    break;
                }

              
                if (socket != null) {
                    synchronized (BluetoothChatService.this) {
                        switch (mState) {
                        case STATE_LISTEN:
                        case STATE_CONNECTING:
                            
                            connected(socket, socket.getRemoteDevice());
                            break;
                        case STATE_NONE:
                        case STATE_CONNECTED:
                            
                            try {
                                socket.close();
                            } catch (IOException e) {
                         
                            }
                            break;
                        }
                    }
                }
            }
          
        }

