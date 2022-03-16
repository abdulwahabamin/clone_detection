    private void Init( String a ) {
        ur = a.charAt( 1 ) == 'r';
        uw = a.charAt( 2 ) == 'w';
        char uxl = a.charAt( 3 );
        if( uxl == 'x' ) {
            ux = true;
            us = false;
        } else 
        if( uxl == 's' ) {
            ux = true;
            us = true;
        } else if( uxl == 'S' ) {
            ux = false;
            us = true;
        } else {
            ux = false;
            us = false;
        }
        gr = a.charAt( 4 ) == 'r';
        gw = a.charAt( 5 ) == 'w';
        char gxl = a.charAt( 6 );
        if( gxl == 'x' ) {
            gx = true;
            gs = false;
        } else 
        if( gxl == 's' ) {
            gx = true;
            gs = true;
        } else 
        if( gxl == 'S' ) {
            gx = false;
            gs = true;
        } else {
            gx = false;
            gs = false;
        }
        or = a.charAt( 7 ) == 'r';
        ow = a.charAt( 8 ) == 'w';
        char otl = a.charAt( 9 );
        if( otl == 'x' ) {
            ox = true;
            ot = false;
        } else 
        if( otl == 't' ) {
            ox = true;
            ot = true;
        } else 
        if( otl == 'T' ) {
            ox = false;
            ot = true;
        } else {
            ox = false;
            ot = false;
        }
    }

