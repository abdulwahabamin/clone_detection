    @Override
    public OutputStream saveContent( Uri u ) {
        if( u != null ) {
            File f = new File( u.getPath() );
            try {
                return new FileOutputStream( f );
            } catch( FileNotFoundException e ) {
                Log.e( TAG, u.getPath(), e );
            }
        }
        return null;
    }

