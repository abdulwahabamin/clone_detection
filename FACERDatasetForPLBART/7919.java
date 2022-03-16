    public final boolean store( String fn, InputStream in, FTP.ProgressSink report_to ) 
            throws InterruptedException {
        try {
            OutputStream out = prepStore( fn );
            if( out == null ) {
                debugPrint( "data socket does not give up the output stream to upload a file" );
                return false;
            }
            byte buf[] = new byte[BLOCK_SIZE];
            int  n = 0;
        	while( true ) {
        		n = in.read( buf );
        		if( n < 0 ) break;
        		out.write( buf, 0, n );
        		if( report_to != null )
        			if( !report_to.completed( n ) ) {
        				delete( fn );
        				return false;
        			}
        	}
        	out.close();
        	return true;
        }
        catch( Exception e ) {
        	debugPrint( "Exception: " + e );
        }
        finally {
        	cleanUpDataCommand( dataSocket != null );
        }
        return false;
    }

