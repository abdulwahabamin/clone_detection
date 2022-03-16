    public final void recoverAfterRefresh( String item_name, int which ) {
        try {
            if( which >= 0  )
                list[which].recoverAfterRefresh( item_name );
            else
                list[current].recoverAfterRefresh( which == current );
            refreshPanelTitles();
            //setPanelCurrent( current, true ); the current panel is set by set focus
        } catch( Exception e ) {
            Log.e( TAG, "refreshList()", e );
        }
    }

