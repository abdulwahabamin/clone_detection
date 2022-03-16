    public boolean fromString( String raw ) {
        if( raw == null ) return false;
        try {
            String[] flds = sep_re.split( raw );
            if( flds == null ) return false;
            comment = null;
            credentials = null;
            String username = null, pass_enc = null;
            for( int i = 0; i < flds.length; i++ ) {
                String s = flds[i];
                if( s == null || s.length() == 0 ) continue;
                if( s.startsWith( "URI=" ) ) uri = Uri.parse( unescape( s.substring( 4 ) ) ); else 
                if( s.startsWith( "CMT=" ) ) comment = unescape( s.substring( 4 ) ); else
                if( s.startsWith( "CRD=" ) ) credentials = Credentials.createFromEncriptedString( unescape( s.substring( 4 ) ) ); else
                if( s.startsWith( "USER=" ) ) username = unescape( s.substring( 5 ) ); else
                if( s.startsWith( "PASS=" ) ) pass_enc = unescape( s.substring( 5 ) );                
                //Log.v( TAG, "Restored to: cmt=" + comment + ", uri=" + uri + ", user=" + username + ", pass=" + ( password != null ? new String( password.getPassword() ) : "" ) );
            }
            if( username != null && pass_enc != null ) {
                credentials = new Credentials( username, Credentials.decrypt( pass_enc ) );
            }
        }
        catch( Exception e ) {
            Log.e( TAG, "can't restore " + raw, e );
        }
        return true;
    }

