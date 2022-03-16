    @Override
    public void run() {
        String msg = null;
        if( !getList( true ) ) {
            Log.w( TAG, "su failed. let's try just sh" );
            errMsg = null;
            msg = context.getString( R.string.no_root );
            getList( false );
        }
        doneReading( msg, pass_back_on_done );
    }

