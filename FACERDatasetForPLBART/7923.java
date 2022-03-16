    public final String getCurrentDir() {
    	sendCommand( "PWD" );
    	// MS IIS responds as: 257 "/" is current directory.
    	// all the others respond as: 257 "/" 
    	String pwd_answer = getReplyLine();
    	if( !isPositiveComplete( getReplyCode( pwd_answer ) ) )
    		return null;
    	String[] parts = pwd_answer.split( "\"" );
    	if( parts.length < 2 )
    		return null;
    	return parts[1];
    }

