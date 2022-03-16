    public String toString() {
        StringBuilder a = new StringBuilder( 64 );
        a.append( "-" );
        a.append( ur ? "r" : "-" ).append( uw ? "w" : "-" ).append( ux ? ( us ? "s" : "x" ) : ( us ? "S" : "-" ) );
        a.append( gr ? "r" : "-" ).append( gw ? "w" : "-" ).append( gx ? ( us ? "s" : "x" ) : ( us ? "S" : "-" ) );
        a.append( or ? "r" : "-" ).append( ow ? "w" : "-" ).append( ox ? ( us ? "t" : "x" ) : ( us ? "T" : "-" ) );
        a.append( " " ).append( user ).append( " " ).append( group );
        return a.toString();
    }

