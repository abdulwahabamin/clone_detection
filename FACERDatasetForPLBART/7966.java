    public final static String join( String[] a, String sep ) {
        if( a == null )
            return "";
        StringBuffer buf = new StringBuffer( 256 );
        boolean first = true;
        for( int i = 0; i < a.length; i++ ) {
            if( first )
                first = false;
            else if( sep != null )
                buf.append( sep );
            buf.append( a[i] );
        }
        return buf.toString();
    }

