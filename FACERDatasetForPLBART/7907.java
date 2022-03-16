    private boolean announcePort( ServerSocket serverSocket )
            throws IOException, InterruptedException {
        int localport = serverSocket.getLocalPort();
        // get local ip address in high byte order
        byte[] addrbytes = cmndSocket.getLocalAddress().getAddress();

        // tell server what port we are listening on
        short addrshorts[] = new short[4];

        // problem: bytes greater than 127 are printed as negative numbers
        for( int i = 0; i <= 3; i++ ) {
            addrshorts[i] = addrbytes[i];
            if( addrshorts[i] < 0 )
                addrshorts[i] += 256;
        }
        String port_command = "PORT " + addrshorts[0] + "," + addrshorts[1] + "," + addrshorts[2] + "," + addrshorts[3] + "," +
                ((localport & 0xff00) >> 8) + "," + (localport & 0x00ff);
        return executeCommand( port_command );
    }

