    private final Socket executeDataCommand( String commands ) {
    	try {
    	    if( commands == null || commands.length() == 0 ) return null;
    	    Socket data_socket = null;
            serverSocket = new ServerSocket( 0 );
            if( !allowActive || !announcePort( serverSocket ) ) {
                flushReply();   // emulator has a bug, it adds \n\r in the end of translated PORT
                serverSocket = null;
                // active mode failed. let's try passive
                final String pasv_command = "PASV";
                sendCommand( pasv_command );
                byte[] addr = new byte[4];
                int server_port = parsePassiveResponse( getReplyLine(), addr );
                if( server_port < 0 ) {
                    debugPrint( "Can't negotiate the PASV" );
                    return null;
                }
                data_socket = new Socket( InetAddress.getByAddress( addr ), server_port );
                if( !data_socket.isConnected() ) {
                    Log.e( TAG, "Can't open PASV data socket" );
                    return null;
                }
            }

            String[] cmds = commands.split( "\n" );
            for( int i = 0; i < cmds.length; i++ ) {
                sendCommand( cmds[i] );
                if( isNegative( getReplyCode( getReplyLine() ) ) ) {
                    Log.e( TAG, "Executing " + cmds[i] + " failed" );
                    return null;
                }
            }            

            if( data_socket == null && serverSocket != null ) {// active mode
                Log.i( TAG, "Awaiting the data connection to PORT" );
            	data_socket = serverSocket.accept(); // will block
            }

            if( data_socket == null || !data_socket.isConnected() ) {
                debugPrint( "Can't establish data connection for " + commands );
                return null;
            }
            return data_socket;
		} catch( Exception e ) {
		    Log.e( TAG, "Exception on executing data command '" + commands + "'", e );
		}
		return null;
    }

