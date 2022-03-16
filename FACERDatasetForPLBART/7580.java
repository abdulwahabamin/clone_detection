    public final void refreshLists() {
        int was_current = current, was_opp = 1 - was_current;
        refreshList( current, true );
        if( sxs )
            refreshList( was_opp, false );
        else
            list[was_opp].setNeedRefresh();
    }

