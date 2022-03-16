    @Override
    protected void onStop() {
        super.onStop();
        if( ca != null )
            ca.prepareToDestroy();
        ca = null;
    }

