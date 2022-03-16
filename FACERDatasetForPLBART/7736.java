    Permissions( String a ) {
        if( a == null ) return;
        Init( a );
        String[] aa = a.substring( 10 ).split( "\\s+" );
        if( aa != null ) {
            if( aa.length >= 3 ) {
                user = aa[1];
                group = aa[2];
            } else {
                user = aa[0];
                if( aa.length > 1 )
                    group = aa[1];
            }
        }       
    }

