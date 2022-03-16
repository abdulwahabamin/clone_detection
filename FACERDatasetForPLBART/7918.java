    public final OutputStream prepStore( String fn ) {
    	
    	dataSocket = null;
        try {
        	if( !isLoggedIn() )
        		return null;
        	executeCommand( "TYPE I" );
        	dataSocket = executeDataCommand( "STOR " + fn );
            if( dataSocket != null )
                return dataSocket.getOutputStream();
        }
        catch( Exception e ) {
            debugPrint( "Exception: " + e );
        }
        return null;
    }

