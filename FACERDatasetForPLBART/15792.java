        Connection listen() throws IOException {
            try {
                Socket socket = serverSocket.accept();
                return new Connection(socket);
            } catch (SocketException e) {
                //Socket closed by close() or stopListening()
            }
            return null;
        }

