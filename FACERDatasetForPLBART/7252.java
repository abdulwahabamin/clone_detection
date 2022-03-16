    @Override
    public boolean copyItems( SparseBooleanArray cis, CommanderAdapter to, boolean move ) {
        String err_msg = null;
        try {
            LsItem[] subItems = bitsToItems( cis );
            if( subItems == null ) {
                notify( s( R.string.copy_err ), Commander.OPERATION_FAILED );
                return false;
            } 
            if( !checkReadyness() ) return false;
            File dest = null;
            int rec_h = 0;
            if( to instanceof FSAdapter  ) {
                dest = new File( to.toString() );
                if( !dest.exists() ) dest.mkdirs();
                if( !dest.isDirectory() )
                    throw new RuntimeException( s( R.string.dest_exist ) );
            } else {
                dest = new File( createTempDir() );
                rec_h = setRecipient( to ); 
            }
            notify( Commander.OPERATION_STARTED );
            worker = new CopyFromEngine( workerHandler, subItems, dest, move, rec_h );
            worker.start();
            return true;
        }
        catch( Exception e ) {
            err_msg = "Exception: " + e.getMessage();
        }
        notify( err_msg, Commander.OPERATION_FAILED );
        return false;
    }

