    public final static boolean copyBytes( InputStream is, OutputStream os ) {
        try {
            byte[] buf = new byte[65536];
            int n;
            while( ( n = is.read( buf ) ) != -1 ) {
                os.write( buf, 0, n );
                Thread.sleep( 1 );
            }
            return true;
        } catch( Exception e ) {
            Log.e( "Utils.copyBytes", "Exception: " + e );
        }
        return false;
    }

