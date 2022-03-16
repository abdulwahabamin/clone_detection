    public Favorite( String uri_str, String comment_ ) {
        try {
            init( Uri.parse( uri_str ) );
            comment = comment_;
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

