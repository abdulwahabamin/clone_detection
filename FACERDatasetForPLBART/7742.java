    StringBuilder generateChownString( Permissions np ) {
        if( np.user  == null || np.user.length()  == 0 ) return null;
        if( np.group == null || np.group.length() == 0 ) return null;
        StringBuilder a = new StringBuilder( 256 );
        a.append( np.user ).append( "." ).append( np.group );
        return a;
    }

