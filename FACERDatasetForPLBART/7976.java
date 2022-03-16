    public static String toHexString( byte[] buf, String delim ) {
        if( buf == null )
            return "";
        StringBuffer result = new StringBuffer( 2 * buf.length );
        for( int i = 0; i < buf.length; i++ ) {
            if( i > 0 && str( delim ) )
                result.append( delim );
            result.append( HEX.charAt( ( buf[i] >> 4 ) & 0x0f ) ).append( HEX.charAt( buf[i] & 0x0f ) );
        }
        return result.toString();
    }

