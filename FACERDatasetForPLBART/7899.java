    private final boolean waitForPositiveResponse() throws InterruptedException {
        String response = null;
        try {
        	int code;
            do {
                Thread.sleep( 100 );
            	response = getReplyLine();
            	if( response == null ) return false;
                code = getReplyCode( response );
                if( isPositiveComplete( code ) )
                    return true;
                if( isNegative( code ) )
                    return false;
                if( isPositiveIntermediate( code ) )
                    return true; // when this occurred?
                Thread.sleep( 400 );
            } while( isPositivePreliminary( code ) );
		} catch( RuntimeException e ) {
            Log.e( TAG, "Exception " + ( response == null ? "" : (" on response '" + response + "'") + "\n" ), e );
		}
        return false;
    }

