    public String toString() {
        try {
            if( uri == null ) return "";
            StringBuffer buf = new StringBuffer( 128 );
            buf.append( "URI=" );
            buf.append( escape( uri.toString() ) );
            if( comment != null ) {
                buf.append( sep );
                buf.append( "CMT=" );
                buf.append( escape( comment ) );
            }
            if( credentials != null ) {
                buf.append( sep );
                buf.append( "CRD=" );
                buf.append( escape( credentials.exportToEncriptedString() ) );
            }
            return buf.toString();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

