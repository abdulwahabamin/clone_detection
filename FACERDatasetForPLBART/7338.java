    @Override
    public boolean receiveItems( String[] uris, int move_mode ) {
    	try {
    		if( !checkReadyness() ) return false;
            if( uris == null || uris.length == 0 ) {
            	notify( s( R.string.copy_err ), Commander.OPERATION_FAILED );
            	return false;
            }
            File[] list = Utils.getListOfFiles( uris );
            if( list == null ) {
            	notify( "Something wrong with the files", Commander.OPERATION_FAILED );
            	return false;
            }
            notify( Commander.OPERATION_STARTED );
            
            zip = null;
            items = null;
            
            worker = new CopyToEngine( workerHandler, list, new File( uri.getPath() ), uri.getFragment(), move_mode );
            worker.start();
            return true;
		} catch( Exception e ) {
			notify( "Exception: " + e.getMessage(), Commander.OPERATION_FAILED );
		}
		return false;
    }

