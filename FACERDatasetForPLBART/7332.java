    @Override
    public boolean deleteItems( SparseBooleanArray cis ) {
        try {
        	if( !checkReadyness() ) return false;
        	ZipEntry[] to_delete = bitsToItems( cis );
        	if( to_delete != null && zip != null && uri != null ) {
        	    notify( Commander.OPERATION_STARTED );
                worker = new DelEngine( workerHandler, new File( uri.getPath() ), to_delete );
                worker.start();
	            return true;
        	}
        }
        catch( Exception e ) {
            Log.e( TAG, "deleteItems()", e );
        }
        notify( null, Commander.OPERATION_FAILED );
        return false;
    }

