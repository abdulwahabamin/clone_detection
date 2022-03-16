    public boolean createZip( File[] list, String zip_fn ) {
        try {
            if( !checkReadyness() ) return false;
            notify( Commander.OPERATION_STARTED );
            worker = new CopyToEngine( workerHandler, list, new File( zip_fn ) );
            worker.start();
            return true;
        } catch( Exception e ) {
            notify( "Exception: " + e.getMessage(), Commander.OPERATION_FAILED );
        }
        return false;
    }

