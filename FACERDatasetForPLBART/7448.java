    public final Credentials searchForPassword( Uri u ) {
        try {
            String ui = u.getUserInfo(); 
            if( ui != null && ui.length() > 0 ) {
                String user = ui.substring( 0, ui.indexOf( ':' ) );
                String host = u.getHost();
                String schm = u.getScheme();
                String path = u.getPath();
                if( path == null || path.length() == 0 ) path = "/"; else Utils.mbAddSl( path );
                int best = -1;
                for( int i = 0; i < size(); i++ ) {
                    try {
                        Favorite f = get( i );
                        if( user.equalsIgnoreCase( f.getUserName() ) ) {
                            Uri fu = f.getUri();
                            if( schm.equals( fu.getScheme() ) ) {
                                if( best < 0 ) best = i;
                                if( host.equalsIgnoreCase( fu.getHost() ) ) {
                                    best = i;
                                    String fp = fu.getPath();
                                    if( fp == null || path.length() == 0 ) fp = "/"; else Utils.mbAddSl( fp );
                                    if( path.equalsIgnoreCase( fp ) )
                                        break;
                                }
                            }
                        }
                    } catch( Exception e ) {}
                }
                if( best >= 0 ) {
                    Favorite f = get( best );
                    return f.borrowPassword( u );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        Log.w( TAG, "Faild to find a suitable Favorite with password!!!" );
        return null;
    }

