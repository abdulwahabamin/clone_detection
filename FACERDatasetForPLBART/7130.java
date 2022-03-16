    protected final void sendReceiveReq( int rcpt_hash, String[] items ) {
        if( thread_handler == null ) return;
        Message msg = thread_handler.obtainMessage();
        Bundle b = new Bundle();
        b.putInt( CommanderAdapterBase.NOTIFY_RECEIVER_HASH, rcpt_hash );
        b.putStringArray( CommanderAdapterBase.NOTIFY_ITEMS_TO_RECEIVE, items );
        msg.setData( b );
        thread_handler.sendMessage( msg );
    }

