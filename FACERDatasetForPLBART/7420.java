    public Favorite( Uri u, Credentials c ) {
        if( c == null )
            init( u );
        else {
            uri = Utils.updateUserInfo( u, null );
            credentials = c;
        }
    }

