	public void setState( State s, int dont_restore ) {
	    Log.v( TAG, "setState()" );
	    if( s == null ) return;
    	resetQuickSearch();
        if( s.favs != null && s.favs.length() > 0 )
            favorites.setFromString( s.favs );
        else
            if( s.fav_uris != null )
                favorites.setFromOldString( s.fav_uris );
        if( dont_restore != LEFT && dont_restore != RIGHT )
    	    current = s.current;
    	if( dont_restore != LEFT ) {
        	Uri lu = s.leftUri != null ? s.leftUri : Uri.parse( "home:" );
            ListHelper list_h = list[LEFT];
            list_h.Navigate( lu, s.leftCrd, s.leftItem, s.current == LEFT );
    	}
    	if( dont_restore != RIGHT ) {
            Uri ru = s.rightUri != null ? s.rightUri : Uri.parse( "home:" ); 
            ListHelper list_h = list[RIGHT];
            list_h.Navigate( ru, s.rightCrd, s.rightItem, s.current == RIGHT );
    	}
        applyColors();
    }

