    public final boolean connect( String host, int port ) throws UnknownHostException, IOException, InterruptedException {
        cmndSocket = new Socket( host, port );
        outputStream = cmndSocket.getOutputStream();
        inputStream = new BufferedInputStream( cmndSocket.getInputStream(), 256 );

        if( !waitForPositiveResponse() ) {
            disconnect( true );
            return false;
        }

        return true;
    }

