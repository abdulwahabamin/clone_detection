    private final boolean cleanUpDataCommand( boolean wait_reps ) throws InterruptedException {
    	
        // Clean up the data structures
        try {
	        if( dataSocket != null )
	        	dataSocket.close();
	        dataSocket = null;
	        if( serverSocket != null )
	            serverSocket.close();
		    serverSocket = null;
		} catch( IOException e ) {
		    Log.e( TAG, "", e );
		}
        return wait_reps ? waitForPositiveResponse() : true;
    }

