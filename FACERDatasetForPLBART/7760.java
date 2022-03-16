    @Override
    public boolean copyItems( SparseBooleanArray cis, CommanderAdapter to, boolean move ) {
        try {
            LsItem[] subItems = bitsToItems( cis );
            if( subItems != null ) {
                String to_path = null;
                int rec_h = 0;
            	if( to instanceof FSAdapter || to instanceof RootAdapter ) {
            	    Uri to_uri = to.getUri();
            	    if( to_uri != null )
            	        to_path = to_uri.getPath();
            	    to = null;
            	} else {
                    to_path = createTempDir();
                    rec_h = setRecipient( to ); 
            	}
                if( to_path != null ) {
                    notify( Commander.OPERATION_STARTED );
                    worker = new CopyFromEngine( commander.getContext(), workerHandler, subItems, to_path, move, rec_h );
                    worker.start();
                    return true;
                }
            }
        	notify( "Failed to proceed.", Commander.OPERATION_FAILED );
        }
        catch( Exception e ) {
            commander.showError( "Exception: " + e );
        }
        return false;
    }

