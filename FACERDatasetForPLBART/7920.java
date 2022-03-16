    public final InputStream prepRetr( String fn, long skip ) throws InterruptedException {
    	dataSocket = null;
        try {
        	if( !isLoggedIn() )
        		return null;
        	executeCommand( "TYPE I" );
        	String retr_cmd = ( skip > 0 ? "REST " + skip + "\n" : "" ) + "RETR " + fn;
        	dataSocket = executeDataCommand( retr_cmd );
            if( dataSocket != null )
                return dataSocket.getInputStream();
        }
        catch( IOException e ) {
            debugPrint( e.getLocalizedMessage() );
        }
        cleanUpDataCommand( dataSocket != null );
        return null;
    }

