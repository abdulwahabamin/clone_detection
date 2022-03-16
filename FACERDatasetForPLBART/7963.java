    public final static Uri updateUserInfo( Uri u, String encoded_ui ) {
        if( u == null ) return null;
        String ea = u.getEncodedAuthority();
        if( ea == null ) return u;
        int at_pos = ea.lastIndexOf( '@' );
        if( encoded_ui == null ) {
            if( at_pos < 0 ) return u;
            ea = ea.substring( at_pos + 1 );
        } else
            ea = encoded_ui + ( at_pos < 0 ? "@" + ea : ea.substring( at_pos ) );
        return u.buildUpon().encodedAuthority( ea ).build();
    }

