    public final void faveSelectedFolder() {
        CommanderAdapter ca = getListAdapter( true );
        if( ca == null ) return;
        Uri u = ca.getUri();
        if( u != null ) {
            int pos = getSelection( true );
            if( pos < 0 ) return;
            Uri to_add = u.buildUpon().appendEncodedPath( ca.getItemName( pos, false ) ).build();
            if( to_add != null ) {
                favorites.addToFavorites( to_add, ca.getCredentials() );
                c.showMessage( c.getString( R.string.fav_added, Favorite.screenPwd( to_add ) ) );
            }
        }
    }    

