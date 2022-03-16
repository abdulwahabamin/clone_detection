    @Override
    public boolean receiveItems( String[] uris, int move_mode ) {
    	try {
            if( uris == null || uris.length == 0 )
            	return false;
            File dest_file = new File( dirName );
            if( dest_file == null )
            	return false;
            if( dest_file.exists() ) {
                if( !dest_file.isDirectory() )
                    return false;
            }
            else {
                if( !dest_file.mkdirs() )
                    return false;
            }
            File[] list = Utils.getListOfFiles( uris );
            if( list != null ) {
                if( worker != null && worker.reqStop() ) {
                    notify( s( R.string.wait ),Commander.OPERATION_FAILED );
                    return false;
                }
                notify( Commander.OPERATION_STARTED );
            	worker = new CopyEngine( workerHandler, list, dirName, ( move_mode & MODE_MOVE ) != 0, false );
            	worker.setName( TAG + ".CopyEngine" );
            	worker.start();
	            return true;
            }
		} catch( Exception e ) {
		    e.printStackTrace();
		}
		return false;
    }

