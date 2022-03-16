        public void run() {
            com.example.manisaiprasad.common.logger.Log.d(TAG, "Socket Type: " + mSocketType +
                    "BEGIN mAcceptThread" + this);
            setName("AcceptThread" + mSocketType);

            BluetoothSocket socket = null;
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                socket = mmServerSocket.accept();
                notifyChatListeners(NotifyChatAction.NOTIFY_CHAT_ACTION_CONNECT_RFCOMM_SOCKET, null);
                int bytesRead = 0;
                do
                {
                    InputStream is = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    bytesRead = is.read(buffer);
                    notifyChatListeners(NotifyChatAction.NOTIFY_CHAT_ACTION_DATA_RFCOMM_SOCKET, buffer);
                }while(bytesRead != 0 && !mEnd);

            } catch (IOException e) {
                notifyChatListeners(NotifyChatAction.NOTIFY_CHAT_ACTION_CONNECTION_ERROR, "Socket Type: " + mSocketType + "accept() failed");
            }
        }

