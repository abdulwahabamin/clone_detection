    public final static String encodeToAuthority( String serv ) {
        String auth = null;
        int cp = serv.lastIndexOf( ':' );
        if( cp > 0 ) {
            String ps = serv.substring( cp + 1 );
            try {
                int port = Integer.parseInt( ps );
                if( port > 0 )
                    auth = Uri.encode( serv.substring( 0, cp ) ) + ":" + port;
            } catch( NumberFormatException e ) {
            }
        }
        if( auth == null )
            auth = Uri.encode( serv );
        return auth;
    }

