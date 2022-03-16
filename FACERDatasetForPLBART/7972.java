    public final static String escapeRest( String s ) {
        if( !str( s ) )
            return s;
        return s.replaceAll( "%", "%25" )
                .replaceAll( "#", "%23" )
                .replaceAll( ":", "%3A" );
    }

