        protected void sendProgress( int v ) {
            Message msg = h.obtainMessage();
            Bundle b = new Bundle();
            b.putInt( "p", v );
            msg.setData( b );
            h.sendMessage( msg );
        }

