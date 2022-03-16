    protected void notify( String s, String cookie ) {
        Message msg = readerHandler.obtainMessage( s != null ? Commander.OPERATION_FAILED :
                                                               Commander.OPERATION_COMPLETED, s );
        if( msg != null ) {
            Bundle b = new Bundle();
            b.putString( Commander.NOTIFY_COOKIE, cookie );
            msg.setData( b );
            msg.sendToTarget();
        }
    }

