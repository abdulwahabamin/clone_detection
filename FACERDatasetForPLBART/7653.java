    @Override
    protected void onStart() {
        super.onStart();
        Uri u = getIntent().getData();
        if( u == null ) return;
        new LoaderThread( this, u ).start();
    }

