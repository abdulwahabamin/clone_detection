    private void startCastServer() {
        castServer = new WebServer(this);
        try {
            castServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

