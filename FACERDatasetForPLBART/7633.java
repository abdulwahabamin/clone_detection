    @Override
    public boolean onLongClick( View v ) {
    	int which = v.getId() == titlesIds[LEFT] ? LEFT : RIGHT;
        locationBar.openGoPanel( which, getFolderUriWithAuth( isCurrent( which ) ) );
    	return true;
    }

