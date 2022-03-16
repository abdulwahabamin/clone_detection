        @Override
        public void run() {
            try {
            	if( uri == null ) {
            		sendProgress( "Wrong URI", Commander.OPERATION_FAILED );
            		return;
            	}
            	Log.i( TAG, "ListEngine started" );
            	synchronized( ftp ) {
                    threadStartedAt = System.currentTimeMillis();
	                ftp.clearLog();
	                if( needReconnect  && ftp.isLoggedIn() ) {
	                    ftp.disconnect( false );
	                }
	                
	                int cl_res = connectAndLogin( uri );
                    if( cl_res < 0 ) {
                        if( cl_res == NO_LOGIN ) 
                            sendProgress( uri.toString(), Commander.OPERATION_FAILED_LOGIN_REQUIRED );
                        return;
                    }
	                if( cl_res == LOGGED_IN )
	                    sendProgress( ctx.getString( R.string.ftp_connected,  
	                            uri.getHost(), theUserPass.getUserName() ), Commander.OPERATION_STARTED );

	                if( ftp.isLoggedIn() ) {
	                    //Log.v( TAG, "ftp is logged in" );
	                	try { // Uri.builder builds incorrect uri?
		                	String active = uri.getQueryParameter( "a" );
		                	ftp.setActiveMode( active != null && 
		                	                 ( 0 == active.compareTo("1")
	                 	                    || 0 == active.compareToIgnoreCase( "true" )  
	                 	                    || 0 == active.compareToIgnoreCase( "yes" ) ) );  
	                	}
	                	catch( Exception e ) {
	                	    Log.e( TAG, "Exception on setActiveMode()", e );
	                	}
                    	items_tmp = ftp.getDirList( null );
                    	String path = ftp.getCurrentDir();
	                    if( path != null ) 
	                    	synchronized( uri ) {
	                    		uri = uri.buildUpon().encodedPath( path ).build();
							}
	                    if( items_tmp != null  ) {
	                        //Log.v( TAG, "Got the items list" );
	                        if( items_tmp.length > 0 ) {
    	                        LsItem.LsItemPropComparator comp = 
    	                            items_tmp[0].new LsItemPropComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
                                Arrays.sort( items_tmp, comp );
	                        }
	                        parentLink = path == null || path.length() == 0 || path.equals( SLS ) ? SLS : PLS;
	                        //Log.v( TAG, "items list sorted" );
	                        sendProgress( tooLong( 8 ) ? ftp.getLog() : null, Commander.OPERATION_COMPLETED, pass_back_on_done );
	                        return;
	                    }
	                    else
	                        Log.e( TAG, "Can't get the items list" );
	                }
	                else
	                    Log.e( TAG, "Did not log in." );
            	}
            }
            catch( UnknownHostException e ) {
                ftp.debugPrint( "Unknown host:\n" + e.getMessage() );
            }
            catch( IOException e ) {
                ftp.debugPrint( "IO exception:\n" + e.getMessage() );
                e.printStackTrace();
            }
            catch( Exception e ) {
                ftp.debugPrint( "Exception:\n" + e );
                e.printStackTrace();
            }
            finally {
            	super.run();
            }
            ftp.disconnect( true );
            sendProgress( ftp.getLog(), Commander.OPERATION_FAILED, pass_back_on_done );
        }

