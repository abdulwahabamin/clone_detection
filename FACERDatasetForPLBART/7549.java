    public final void recoverAfterRefresh( boolean this_current ) { // to be called for the current panel
        try {
            reStoreChoosedItems();
            flv.invalidateViews();
            if( this_current && !flv.isInTouchMode() && currentPosition > 0 ) {
                //Log.v( TAG, "restoring pos: " + currentPosition );
                setSelection( currentPosition, flv.getHeight() / 2 );
            }
        } catch( Exception e ) {
            Log.e( TAG, "recoverAfterRefresh()", e );
        }
    }

