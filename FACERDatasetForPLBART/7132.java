    protected final void error( String err ) {
        Log.e( getClass().getSimpleName(), err == null ? "Unknown error" : err );
    	if( errMsg == null )
    		errMsg = err;
    	else
    		errMsg += "\n" + err;
    }

