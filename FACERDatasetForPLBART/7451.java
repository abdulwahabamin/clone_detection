    public final void setFromString( String stored ) {
        if( stored == null ) return;
        clear();
        String use_sep = sep;
        String[] favs = stored.split( use_sep );
        try {
            for( int i = 0; i < favs.length; i++ ) {
                String stored_fav = unescape( favs[i] );
                //Log.v( TAG, "fav: " + stored_fav );
                add( new Favorite( stored_fav ) );
            }
        } catch( NoSuchElementException e ) {
            Log.e( TAG, null, e );
        }
        if( isEmpty() )
            add( new Favorite( "home:", c.getString( R.string.default_uri_cmnt ) ) );
    }

