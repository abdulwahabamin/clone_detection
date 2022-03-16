    private final void setPanelCurrent( int which, boolean dont_focus ) {
        Log.v( TAG, "setPanelCurrent: " + which + " dnf:" + dont_focus );
        if( !dont_focus && panelsView != null ) {
            panelsView.setMode( sxs );
        }
        current = which;
        if( !sxs ) {
            final int dir = current == LEFT ? HorizontalScrollView.FOCUS_LEFT : HorizontalScrollView.FOCUS_RIGHT;
            Log.v( TAG, "fullScroll: " + dir );
            if( dont_focus )
                hsv.fullScroll( dir );
            else {
                hsv.post( new Runnable() {
                    public void run() {
                        Log.v( TAG, "fullScroll: " + dir );
                        hsv.fullScroll( dir );
                    }
                } );
            }
        }
        else
            if( !dont_focus )
                list[current].focus();
        highlightCurrentTitle();
        setToolbarButtons( getListAdapter( true ) );
        if( list[current].needRefresh() ) 
            refreshList( current, false );
    }

