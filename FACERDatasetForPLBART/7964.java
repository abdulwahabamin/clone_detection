    public final static Uri addTrailngSlash( Uri u ) {
        String alt_path, path = u.getEncodedPath();
        if( path == null )
            alt_path = "/";
        else {
            alt_path = Utils.mbAddSl( path );
            if( alt_path == null || path.equals( alt_path ) ) return u;
        }
        return u.buildUpon().encodedPath( alt_path ).build(); 
    }

