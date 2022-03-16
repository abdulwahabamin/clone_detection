    protected final void sendLoginReq( String s, Credentials crd ) {
        if( thread_handler == null ) return;
        Message msg = thread_handler.obtainMessage( Commander.OPERATION_FAILED_LOGIN_REQUIRED, -1, -1, s );
        Bundle b = new Bundle();
        b.putParcelable( Commander.NOTIFY_CRD, crd );
        msg.setData( b );
        thread_handler.sendMessage( msg );
    }

