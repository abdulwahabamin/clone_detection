    private final boolean checkReadyness()   
    {
        if( worker != null ) {
        	notify( "ftp adapter is busy!", Commander.OPERATION_FAILED );
        	return false;
        }
        if( !ftp.isLoggedIn() ) {
        	notify( s( R.string.ftp_nologin ), Commander.OPERATION_FAILED );
        	return false;
        }
    	return true;
    }

