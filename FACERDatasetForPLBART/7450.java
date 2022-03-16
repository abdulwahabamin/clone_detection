    public final void setFromOldString( String stored ) {
        try {
            if( stored != null && stored.length() != 0 ) { 
                clear();
                String use_sep = old_sep;
                String[] favs = stored.split( use_sep );
                for( int i = 0; i < favs.length; i++ ) {
                    if( favs[i] != null && favs[i].length() > 0 )
                        add( new Favorite( favs[i], null ) );
                }
            }
            if( isEmpty() ) {
                add( new Favorite( HomeAdapter.DEFAULT_LOC, c.getString( R.string.home ) ) );
                add( new Favorite( Panels.DEFAULT_LOC, c.getString( R.string.default_uri_cmnt ) ) );
            }
        } catch( Throwable e ) {
            Log.e( TAG, null, e );
        }
    }

