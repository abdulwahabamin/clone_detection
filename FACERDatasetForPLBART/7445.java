    public final void addToFavorites( Uri u, Credentials crd ) {
        removeFromFavorites( u );
        if( crd == null && Favorite.isPwdScreened( u ) )
            crd = searchForPassword( u );
        add( new Favorite( u, crd ) );
    }

