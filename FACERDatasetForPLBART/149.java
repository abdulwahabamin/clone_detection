        public void cancel() {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }

