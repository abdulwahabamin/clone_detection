	    @Override
	    public void run() {
	        try {
	            boolean ok = execute();
                if( counter > 0 && recipient_hash != 0 ) {
                    File temp_dir = new File( dest_folder );
                    File[] temp_content = temp_dir.listFiles();
                    String[] paths = new String[temp_content.length];
                    for( int i = 0; i < temp_content.length; i++ )
                        paths[i] = temp_content[i].getAbsolutePath();
                    sendReceiveReq( recipient_hash, paths );
                    return;
                }
                if( !ok )
                    counter = 0;
            }
            catch( Exception e ) {
                error( "Exception: " + e );
            }
            sendResult( counter > 0 ? Utils.getOpReport( commander.getContext(), counter, move ? R.string.moved : R.string.copied ) : "" );
        }

