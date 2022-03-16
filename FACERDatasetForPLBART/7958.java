    public final static long parseHumanSize( String s ) {
        if( s == null )
            return 0;
        final char[] sxs = { 'K', 'M', 'G', 'T' };
        long m = 1024;
        int s_pos;
        s = s.toUpperCase();
        try {
            for( int i = 0; i < 4; i++ ) {
                s_pos = s.indexOf( sxs[i] );
                if( s_pos > 0 ) {
                    float v = Float.parseFloat( s.substring( 0, s_pos ) );
                    return (long)( v * m );
                }
                m *= 1024;
            }
            s_pos = s.indexOf( 'B' );
            return Long.parseLong( s_pos > 0 ? s.substring( 0, s_pos ) : s );
        } catch( NumberFormatException e ) {
            e.printStackTrace();
        }
        return 0;
    }

