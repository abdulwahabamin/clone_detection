    @Override
    public boolean readSource( Uri tmp_uri, String pass_back_on_done ) {
        try {
            if( tmp_uri != null )
                uri = tmp_uri;
            if( uri == null )
                return false;
            if( reader != null ) { // that's not good.
                if( reader.isAlive() ) {
                    commander.showInfo( ctx.getString( R.string.busy ) );
                    reader.interrupt();
                    Thread.sleep( 500 );      
                    if( reader.isAlive() ) 
                        return false;      
                }
            }
            Log.v( TAG, "reading " + uri );
            notify( Commander.OPERATION_STARTED );
            reader = new ListEngine( readerHandler, pass_back_on_done );
            reader.start();
            return true;
        }
        catch( Exception e ) {
            commander.showError( "Exception: " + e );
            e.printStackTrace();
        }
        notify( "Fail", Commander.OPERATION_FAILED );
        return false;
    }

