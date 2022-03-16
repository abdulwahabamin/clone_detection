    public final int findIgnoreAuth( Uri u ) {
        try {
            if( u != null ) {
                u = Utils.addTrailngSlash( Utils.updateUserInfo( u, null ) );
                //Log.v( TAG, "looking for URI:" + u );
                for( int i = 0; i < size(); i++ ) {
                    Uri fu = Utils.addTrailngSlash( get( i ).getUri() );
                    //Log.v( TAG, "probing URI:" + fu );
                    if( fu.equals( u ) )
                        return i;
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, "Uri: " + Favorite.screenPwd( u ), e );
        }
        return -1;
    }

