    public final void Destroy() {
        Log.i( TAG, "Destroing" );
        try {
            getListAdapter( false ).prepareToDestroy();
            getListAdapter( true  ).prepareToDestroy();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

