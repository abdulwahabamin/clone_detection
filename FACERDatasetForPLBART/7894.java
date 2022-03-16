    public final void debugPrint( String message ) {
        Log.v( TAG, message );
        if( PRINT_DEBUG_INFO ) {
            debugBuf.append( message );
            debugBuf.append( "\n" );
        }
    }

