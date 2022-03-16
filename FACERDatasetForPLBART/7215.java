    @Override
    public boolean deleteItems( SparseBooleanArray cis ) {
    	try {
        	FileItem[] list = bitsToFilesEx( cis );
        	if( list != null ) {
        		if( worker != null && worker.reqStop() ) {
        		    notify( s( R.string.wait ), 
        		            Commander.OPERATION_FAILED );
       		        return false;
        		}
        		notify( Commander.OPERATION_STARTED );
        		worker = new DeleteEngine( workerHandler, list );
        		worker.setName( TAG + ".DeleteEngine" );
        		worker.start();
        	}
		} catch( Exception e ) {
		    notify( e.getMessage(), Commander.OPERATION_FAILED );
		}
        return false;
    }

