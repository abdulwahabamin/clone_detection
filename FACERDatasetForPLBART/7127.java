    protected final void sendProgress( String s, int p1, int p2, int speed ) {
        //Log.v( TAG, "sendProgress: " + speed );
        if( thread_handler == null ) return;
        Message msg = null;
        if( p1 < 0 )
            msg = thread_handler.obtainMessage( p1, -1, -1, s );
        else
            msg = thread_handler.obtainMessage( Commander.OPERATION_IN_PROGRESS, p1, p2, s );
        
        if( speed > 0 ) {
            Bundle b = new Bundle();
            b.putInt( Commander.NOTIFY_SPEED, speed );
            msg.setData( b );
        }
        thread_handler.sendMessage( msg );
    }

