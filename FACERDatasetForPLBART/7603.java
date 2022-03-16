    public final void addCurrentToFavorites() {
        CommanderAdapter ca = getListAdapter( true );
        if( ca == null ) return;
        Uri u = ca.getUri();
        favorites.addToFavorites( u, ca.getCredentials() );
        c.showMessage( c.getString( R.string.fav_added, Favorite.screenPwd( u ) ) );
    }

