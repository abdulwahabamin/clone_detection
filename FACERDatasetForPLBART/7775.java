    @Override
    public boolean receiveItems( String[] full_names, int move_mode ) {
    	try {
            if( full_names == null || full_names.length == 0 ) {
            	notify( "Nothing to copy", Commander.OPERATION_FAILED );
            	return false;
            }
            notify( Commander.OPERATION_STARTED );
            worker = new CopyToEngine( commander.getContext(), workerHandler, full_names, 
                                     ( move_mode & MODE_MOVE ) != 0, uri.getPath(), false );
            worker.start();
            return true;
		} catch( Exception e ) {
			notify( "Exception: " + e, Commander.OPERATION_FAILED );
		}
		return false;
    }

