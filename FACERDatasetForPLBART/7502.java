    @Override
    protected void onNewIntent( Intent intent ) {
        on = true;
        super.onNewIntent( intent );
        try {
            Message msg = intent.getParcelableExtra( PARCEL );
            if( msg != null ) {
                notifyMe( msg );
                return;
            }
            Log.v( TAG, "No parcel found in the intent." );
        } catch( Exception e ) {
            Log.e( TAG, "Can't extract a parcel from intent", e );
        }
    }

