    public final boolean retrieve( String fn, OutputStream out, FTP.ProgressSink report_to ) throws InterruptedException {
        InputStream in = prepRetr( fn, 0 );
        if( in == null )
            return false;
        try {
            byte buf[] = new byte[BLOCK_SIZE];
            int  n = 0;
        	while( true ) {
        		n = in.read( buf );
        		//Log.v( TAG, "FTP has read " + n + "bytes" );
        		if( n < 0 ) break;
        		out.write( buf, 0, n );
        		if( report_to != null ) {
        			if( !report_to.completed( n ) ) {
        			    executeCommand( "ABOR" );
        				return false;
        			}
        		}
        	}
        	return true;
        }
        catch( IOException e ) {
        	debugPrint( "Exception: " + e );
        }
        finally {
        	try {
				if( in  != null )  in.close();
				if( out != null ) out.close();
			} catch( IOException e ) {
			    Log.e( TAG, "Exception on streams closing (finnaly section)", e );
			}
        	cleanUpDataCommand( dataSocket != null );
        }
        return false;
    }

