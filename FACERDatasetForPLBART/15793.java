        @Override
        public void close() {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    //TODO: handle if needed
                }
            }
        }

