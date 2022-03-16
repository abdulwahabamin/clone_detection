    @Override
    public void onFocusChange( View v, boolean f ) {
        ListView flv = list[opposite()].flv;
        boolean opp = flv == v; 
        if( f && opp ) {
            Log.v( TAG, "focus has changed to " + ( opposite()==LEFT?"LEFT":"RIGHT" ) );
            setPanelCurrent( opposite(), true );
        }
    
    }

