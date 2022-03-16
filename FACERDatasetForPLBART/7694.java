    protected boolean cmdDialog( OutputStreamWriter os, BufferedReader is, BufferedReader es ) { 
        try {
            if( command != null )
                outCmd( use_busybox, command, os );
            boolean err = procError( es );
            if( !is.ready() ) // may be an error may be not
                Log.w( TAG, "No output from the executed command " + command );
            procInput( is );
            return !err;
        } catch( Exception e ) {
            error( e.getMessage() );
            if( command != null ) 
                Log.e( TAG, "Exception '" + e.getMessage() + "' nn execution '" + command + "'" );
        }
        return false;
    }    

