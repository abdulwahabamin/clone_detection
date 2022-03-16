    @Override
    public OutputStream saveContent( Uri u ) {
        try {
            if( uri != null && !uri.getHost().equals( u.getHost() ) )
                return null;
            synchronized( ftp ) {
                if( connectAndLogin( u, false ) > 0 ) {
                    noHeartBeats = true;
                    return ftp.prepStore( u.getPath() );
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, u.getPath(), e );
        }
        return null;
    }

