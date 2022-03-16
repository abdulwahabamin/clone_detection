    public final void removeFromFavorites( Uri u ) {
        int pos = findIgnoreAuth( u );
        if( pos >= 0 )
            remove( pos );
        else
            Log.w( TAG, "Can't find in the list of favs:" + u );
    }

