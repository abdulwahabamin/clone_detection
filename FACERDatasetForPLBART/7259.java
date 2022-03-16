	@Override
	public boolean createFile( String fileURI ) {
		notify( "Operation not supported on a FTP folder.", 
		                        Commander.OPERATION_FAILED );
		return false;
	}

