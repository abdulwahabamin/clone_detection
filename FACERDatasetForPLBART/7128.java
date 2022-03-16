    protected final void sendProgress( String s, int p, String cookie ) {
        //Log.v( TAG, "sendProgress: " + s + ", cookie: " + cookie );
        if( thread_handler == null ) return;
        Message msg = null;
        if( p < 0 )
            msg = thread_handler.obtainMessage( p, -1, -1, s );
        else
            msg = thread_handler.obtainMessage( Commander.OPERATION_IN_PROGRESS, p, -1, s );
        Bundle b = new Bundle();
        b.putString( Commander.NOTIFY_COOKIE, cookie );
        msg.setData( b );
        thread_handler.sendMessage( msg );
    }

