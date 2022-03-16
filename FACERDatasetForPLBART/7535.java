    public final void refreshList( boolean was_current_ ) {
        try {
            was_current = was_current_;
            CommanderAdapter ca = (CommanderAdapter)flv.getAdapter();
            if( ca == null )
                return;
            storeChoosedItems();
            flv.clearChoices();
            ca.readSource( null, null );
            flv.invalidateViews();
            needRefresh = false;
        } catch( Exception e ) {
            Log.e( TAG, "refreshList()", e );
        }
    }

