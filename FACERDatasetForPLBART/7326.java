    @Override
    public boolean copyItems( SparseBooleanArray cis, CommanderAdapter to, boolean move ) {
        try {
            if( zip == null )
                throw new RuntimeException( "Invalid ZIP" );
            ZipEntry[] subItems = bitsToItems( cis );
            if( subItems == null ) 
                throw new RuntimeException( "Nothing to extract" );
            if( !checkReadyness() ) return false;
            File dest = null;
            int rec_h = 0;
            if( to instanceof FSAdapter  ) {
                dest = new File( to.toString() );
                if( !dest.exists() ) dest.mkdirs();
                if( !dest.isDirectory() )
                    throw new RuntimeException( ctx.getString( R.string.dest_exist ) );
            } else {
                dest = new File( createTempDir() );
                rec_h = setRecipient( to ); 
            }
            notify( Commander.OPERATION_STARTED );
            worker = new CopyFromEngine( workerHandler, subItems, dest, rec_h );
            worker.start();
            return true;
        }
        catch( Exception e ) {
            commander.showError( "Exception: " + e.getMessage() );
        }
        return false;
    }

