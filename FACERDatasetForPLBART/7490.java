    @Override
    public void issue( Intent in, int ret ) {
        if( in == null ) return;
        try {
            if( ret == 0 )
                startActivity( in );
            else
                startActivityForResult( in, ret );
        } catch( Exception e ) {
            Log.e( TAG, in.getDataString(), e );
        }
    }

