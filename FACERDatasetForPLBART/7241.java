    @Override
    public boolean readSource( Uri tmp_uri, String pass_back_on_done ) {
        try {
            boolean need_reconnect = false;
            if( tmp_uri != null ) { 
                String new_user_info = tmp_uri.getUserInfo();
                if( uri == null ) 
                    need_reconnect = true;
                else if( !tmp_uri.getHost().equalsIgnoreCase( uri.getHost() ) ) {
                    need_reconnect = true;
                    theUserPass = null;
                }
                else if( new_user_info != null  ) {
                    if( theUserPass == null )
                        need_reconnect = true;
                    else if( theUserPass != null && !theUserPass.equals( new FTPCredentials( new_user_info ) ) )
                        need_reconnect = true;
                }
                else
                    if( theUserPass != null )
                        need_reconnect = theUserPass.dirty; 
                if( uri != null ) 
                    synchronized( uri ) {
                        uri = tmp_uri;
                    }
                else
                    uri = tmp_uri;
            }
            else
                if( uri == null )
                    return false;
            if( reader != null ) { // that's not good.
                Log.w( TAG, "reader's existed!" );
                if( reader.isAlive() ) {
                    Log.e( TAG, "reader's busy!" );
                        return false;      
                }
            }
            notify( Commander.OPERATION_STARTED );
            Log.v( TAG, "Creating and starting the reader..." );
            reader = new ListEngine( readerHandler, need_reconnect, pass_back_on_done );
            reader.start();
            
            if( heartBeat == null ) {
                heartBeat = new Timer( "FTP Heartbeat", true );
                heartBeat.schedule( new Noop(), 120000, 40000 );
            }
            return true;
        }
        catch( Exception e ) {
            commander.showError( "Exception: " + e );
            e.printStackTrace();
        }
        notify( ftp.getLog(), Commander.OPERATION_FAILED );
        return false;
    }

