    @Override
    public InputStream getContent( Uri u, long skip ) {
        try {
            if( uri != null && !uri.getHost().equals( u.getHost() ) )
                return null;
            synchronized( ftp ) {
                if( connectAndLogin( u, false ) > 0 ) {
                    noHeartBeats = true;
                    return ftp.prepRetr( u.getPath(), skip );
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, u.getPath(), e );
        }
        return null;
    }

