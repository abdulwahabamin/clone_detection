    @Override
    public void openItem( int position ) {
        if( position == 0 ) {
            commander.Navigate( Uri.parse( "home:" ), null, null );
            return;
        }
        if( favs == null || position < 0 || position > numItems )
            return;
        Favorite f = favs.get( position - 1 );
        if( f != null )
            commander.Navigate( f.getUri(), f.getCredentials(), null );
    }

