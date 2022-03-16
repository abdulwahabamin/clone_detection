    public final void recoverAfterRefresh( String item_name ) {
        try {
            Log.v( TAG, "restoring panel " + which + " item: " + item_name );
            if( item_name != null && item_name.length() > 0 )
                setSelection( item_name );
            else
                setSelection( 0, 0 );
            if( was_current ) {
                Log.v( TAG, "this was the current panel, let's focus it" );
                focus();
                was_current = false;
            }
        } catch( Exception e ) {
            Log.e( TAG, "recoverAfterRefresh()", e );
        }
    }

