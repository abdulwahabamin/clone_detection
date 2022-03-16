	    @Override
	    public void run() {
	    	try {
                if( connectAndLogin( uri ) < 0 ) {
                    error( s( R.string.ftp_nologin ) );
                    sendResult( "" );
                    return;
                }
	    	    
	    	    wifiLock.acquire();
                int total = copyFiles( mList, "" );
                wifiLock.release();
                
                if( recipient_hash != 0 ) {
                      sendReceiveReq( recipient_hash, dest_folder );
                      return;
                }
                sendResult( Utils.getOpReport( ctx, total, R.string.downloaded ) );
            } catch( InterruptedException e ) {
                sendResult( ctx.getString( R.string.canceled ) );
            } catch( Exception e ) {
                error( ctx.getString( R.string.failed ) + e.getLocalizedMessage() );
                e.printStackTrace();
            }
	        super.run();
	    }

