    StringBuilder generateChmodString( Permissions np ) {
        StringBuilder a = new StringBuilder( 256 );
        if( np.ur != ur ) {
            a.append( 'u' ).append( np.ur ? '+' : '-' ).append( 'r' );  
        }
        if( np.uw != uw ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'u' ).append( np.uw ? '+' : '-' ).append( 'w' );  
        }
        if( np.ux != ux ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'u' ).append( np.ux ? '+' : '-' ).append( 'x' );  
        }
        if( np.us != us ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'u' ).append( np.us ? '+' : '-' ).append( 's' );  
        }
        
        if( np.gr != gr ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'g' ).append( np.gr ? '+' : '-' ).append( 'r' );  
        }
        if( np.gw != gw ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'g' ).append( np.gw ? '+' : '-' ).append( 'w' );  
        }
        if( np.gx != gx ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'g' ).append( np.gx ? '+' : '-' ).append( 'x' );  
        }
        if( np.gs != gs ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'g' ).append( np.gs ? '+' : '-' ).append( 's' );  
        }
        
        if( np.or != or ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'o' ).append( np.or ? '+' : '-' ).append( 'r' );  
        }
        if( np.ow != ow ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'o' ).append( np.ow ? '+' : '-' ).append( 'w' );  
        }
        if( np.ox != ox ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( 'o' ).append( np.ox ? '+' : '-' ).append( 'x' );  
        }
        if( np.ot != ot ) {
            if( a.length() > 0 )
                a.append( ',' );
            a.append( np.ot ? '+' : '-' );
            a.append( 't' );  
        }
        return a;
    }

