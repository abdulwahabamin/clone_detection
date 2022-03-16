    @Override
    public void run() {
        try {
            if( command == null ) return;
            execute();
        } catch( Exception e ) {
            error( "Exception: " + e );
        }
        synchronized( this ) {
            done = true;
            notify();
        }
        if( thread_handler != null )
            sendResult( result != null && result.length() > 0 ? result.toString() : 
                   ( errMsg != null ? "\nFailed to execute \"" + command + "\"" : null ) );
    }

