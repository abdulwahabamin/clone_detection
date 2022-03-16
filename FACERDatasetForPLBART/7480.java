    @Override
    protected void onDestroy() {
        //Log.v( TAG, "Destroying\n");
        on = false;
        super.onDestroy();
        if( isFinishing() && exit ) {
            if( notMan != null ) notMan.cancelAll();
            panels.Destroy();
            Log.i( TAG, "Good bye cruel world...");
            System.exit( 0 );
        }
    }

