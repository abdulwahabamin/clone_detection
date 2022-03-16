    public final LsItem[] getDirList( String path ) throws InterruptedException {
    	if( !isLoggedIn() )
    		return null;        	
    	String cur_dir = null;
    	if( path != null && path.length() > 0 ) {
        	// some servers do not understand the LIST's parameter and always return the list of the current directory
    		cur_dir = getCurrentDir();
        	if( cur_dir == null )
        		return null;
        	setCurrentDir( path );
    	}
    	ArrayList<LsItem> array = null;
        try {
            dataSocket = executeDataCommand( "LIST" );
            if( dataSocket == null )
            	return null;
            inDataStream = dataSocket.getInputStream();
            if( inDataStream == null ) {
                debugPrint( "data socket does not give up the input stream" );
                return null;
            }
            BufferedReader dataReader = new BufferedReader( new InputStreamReader( inDataStream ), 4096 );
        	array = new ArrayList<LsItem>(); 
        	
            final String dot = ".";
            final String dotdot = "..";
        	while( true ) {
        		String dir_line = dataReader.readLine();
        		if( dir_line == null ) break;
        		LsItem item = new LsItem( dir_line );
        		String name = item.getName();
        		if( item.isValid() && !dotdot.equals( name ) && !dot.equals( name ) )
        			array.add( item );
        	}
        	inDataStream.close();
        	if( cur_dir != null )
        		setCurrentDir( cur_dir );
        }
        catch( Exception e ) {
        	debugPrint( "Exception: " + e );
        }
        finally {
        	cleanUpDataCommand( dataSocket != null );
        }
        if( array != null ) {
            LsItem[] result = new LsItem[array.size()]; 
	        return array.toArray( result );
        }
        return null;
    }

