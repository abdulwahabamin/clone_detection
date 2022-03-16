    @Override
    protected void onPause() {
        try {
            super.onPause();
            ck.store();
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }

