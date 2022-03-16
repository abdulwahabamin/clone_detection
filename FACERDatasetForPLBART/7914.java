    public final boolean login( String username, String password ) throws IOException, InterruptedException {
        if( !executeCommand( "USER " + username ) )
            return false;
        loggedIn = executeCommand( "PASS " + password );
        return loggedIn;
    }

