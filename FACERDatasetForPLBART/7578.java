    public void changeSorting( int sort_mode ) {
        CommanderAdapter ca = getListAdapter( true );
        
        int cur_mode = ca.setMode( 0, 0 );
        boolean asc = ( cur_mode & CommanderAdapter.MODE_SORT_DIR ) == CommanderAdapter.SORT_ASC;
        int sorted = cur_mode & CommanderAdapter.MODE_SORTING; 
        storeChoosedItems();
        if( sorted == sort_mode ) 
            ca.setMode( CommanderAdapter.MODE_SORT_DIR, asc ? CommanderAdapter.SORT_DSC : CommanderAdapter.SORT_ASC );
        else
            ca.setMode( CommanderAdapter.MODE_SORTING | CommanderAdapter.MODE_SORT_DIR, 
                                            sort_mode | CommanderAdapter.SORT_ASC );
        reStoreChoosedItems();
    }

