    public final void setLayoutMode( boolean sxs_ ) {
        sxs = sxs_;
        SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( c );
        applySettings( shared_pref, false );
        scroll_back = (int)( c.getWindowManager().getDefaultDisplay().getWidth() * 2. / 10 );        
        if( panelsView != null ) panelsView.setMode( sxs_ );
    }

