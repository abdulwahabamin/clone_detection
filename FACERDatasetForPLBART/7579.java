    public void toggleHidden() {
        CommanderAdapter ca = getListAdapter( true );
        
        int cur_mode = ca.setMode( 0, 0 );
        int new_mode = ( cur_mode & CommanderAdapter.MODE_HIDDEN ) == CommanderAdapter.SHOW_MODE ?
                                         CommanderAdapter.HIDE_MODE : CommanderAdapter.SHOW_MODE;
        ca.setMode( CommanderAdapter.MODE_HIDDEN, new_mode );
        refreshList( current, true );
    }

