    public final static CharSequence readStreamToBuffer( InputStream is, String encoding ) {
        if( is != null ) {
            try {
                int bytes = is.available();
                if( bytes < 1024 || bytes > 1048576 )
                    bytes = 10240;
                char[] chars = new char[bytes];
                InputStreamReader isr = null;
                if( str( encoding ) ) {
                    try {
                        isr = new InputStreamReader( is, encoding );
                    } catch( UnsupportedEncodingException e ) {
                        Log.w( "GC", encoding, e );
                        isr = new InputStreamReader( is );
                    }
                } else
                    isr = new InputStreamReader( is );
                StringBuffer sb = new StringBuffer( bytes );
                int n = -1;
                boolean available_supported = is.available() > 0;
                while( true ) {
                    n = isr.read( chars, 0, bytes );
                    // Log.v( "readStreamToBuffer", "Have read " + n + " chars"
                    // );
                    if( n < 0 )
                        break;
                    for( int i = 0; i < n; i++ ) {
                        if( chars[i] == 0x0D )
                            chars[i] = ' ';
                    }
                    sb.append( chars, 0, n );
                    if( available_supported ) {
                        for( int i = 0; i < 10; i++ ) {
                            if( is.available() > 0 )
                                break;
                            // Log.v( "readStreamToBuffer", "Waiting the rest "
                            // + i );
                            Thread.sleep( 20 );
                        }
                        if( is.available() == 0 ) {
                            // Log.v( "readStreamToBuffer", "No more data!" );
                            break;
                        }
                    }
                }
                return sb;
            } catch( Throwable e ) {
                Log.e( "Utils.readStreamToBuffer()", "Error on reading a stream", e );
            }
        }
        return null;
    }

