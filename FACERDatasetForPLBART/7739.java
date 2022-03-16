    StringBuilder generateChmodString() {
        StringBuilder a = new StringBuilder( 256 );
        a.append( 'u' ).append( ur ? '+' : '-' ).append( 'r' ).append( ',' );
        a.append( 'u' ).append( uw ? '+' : '-' ).append( 'w' ).append( ',' );
        a.append( 'u' ).append( ux ? '+' : '-' ).append( 'x' ).append( ',' );
        a.append( 'u' ).append( us ? '+' : '-' ).append( 's' ).append( ',' );
        a.append( 'g' ).append( gr ? '+' : '-' ).append( 'r' ).append( ',' );
        a.append( 'g' ).append( gw ? '+' : '-' ).append( 'w' ).append( ',' );
        a.append( 'g' ).append( gx ? '+' : '-' ).append( 'x' ).append( ',' );
        a.append( 'g' ).append( gs ? '+' : '-' ).append( 's' ).append( ',' );
        a.append( 'o' ).append( or ? '+' : '-' ).append( 'r' ).append( ',' );
        a.append( 'o' ).append( ow ? '+' : '-' ).append( 'w' ).append( ',' );
        a.append( 'o' ).append( ox ? '+' : '-' ).append( 'x' ).append( ',' );
        a.append( ot ? '+' : '-' ).append( 't' );  
        return a;
    }

