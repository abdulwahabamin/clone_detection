    @Override
    public void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            //TODO: handle if needed
        }
    }

