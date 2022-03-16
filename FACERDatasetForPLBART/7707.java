    @Override
    public boolean readSource( Uri tmp_uri, String pass_back_on_done ) {
        try {
            if( tmp_uri != null )
                uri = tmp_uri;
            if( uri == null )
                return false;
            
            if( reader != null ) {
                Log.w( TAG, "Busy " + attempts );
                if( attempts++ < 2 ) {
                    commander.showInfo( s( R.string.busy ) );
                    return false;
                }
                if( reader.reqStop() ) { // that's not good.
                    Thread.sleep( 500 );      // will it end itself?
                    if( reader.isAlive() ) {
                        Log.e( TAG, "Busy!" );
                        return false;
                    }
                }
            }
            notify( Commander.OPERATION_STARTED );
            reader = new MountsListEngine( commander.getContext(), readerHandler, pass_back_on_done );
            reader.start();
            return true;
        }
        catch( Exception e ) {
            commander.showError( "Exception: " + e );
            e.printStackTrace();
        }
        notify( s( R.string.fail ), Commander.OPERATION_FAILED );
        return false;
    }

