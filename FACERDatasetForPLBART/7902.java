    private final String getReplyLine() {
        try {
        	if( inputStream == null ) {
        		debugPrint( "No Connection" );
        		return null;
        	}
            final int buf_sz = 1024;
            int i;
            byte[] buf = new byte[buf_sz];
            do {
            	int cnt = 0;
            	do
            		if( cnt++ < 200 ) 
            		    Thread.sleep( 100 ); 
            		else {
            		    Log.e( TAG, "The server did not respond. " + inputStream.toString() );
            		    return null;
            		}
            	while( inputStream != null && inputStream.available() == 0 );
                for( i = 0; i < buf_sz; i++ ) {
                    int b = inputStream.read();
                    if( b < 0 )
                        break;
                    if( b == '\r' || b == '\n' ) {
                        buf[i] = 0;
                        break;
                    }
                    buf[i] = (byte)b;
                }
//Log.v( TAG, "\nfrom FTP:" + new String( buf, 0, i ) + "\n" );
            } while( !(Character.isDigit( buf[0] ) &&
                       Character.isDigit( buf[1] ) &&
                       Character.isDigit( buf[2] ) && buf[3] == ' ' ) ); // read until a coded response be found
            String reply = new String( buf, 0, i );
            debugPrint( "<<< " + reply );
            return reply;
        }
        catch( Exception e ) {
            Log.e( TAG, "", e );
            disconnect( true );
            return null;
		}
    }

