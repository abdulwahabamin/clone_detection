    private final boolean sendCommand( String cmd ) {
        try {
        	if( outputStream == null || cmndSocket == null || !cmndSocket.isConnected() )
        		return false;
        	String out = cmd.startsWith( "PASS" ) ? "PASS ***" : cmd;
        	debugPrint( ">>> " + out );
            byte[] bytes = ( cmd + "\r\n" ).getBytes();
            outputStream.write( bytes );
            return true;
        }
        catch( IOException e ) {
            debugPrint( "connection broken" );
        }
        return false;
    }

