    @Override
    public InputStream getContent( Uri u ) {
        try {
            if( u == null ) return null;
            String path = u.getPath();
            contentEngine = new ContentEngine( path );
            contentEngine.start();
            InputStream is = contentEngine.getInput();
            if( is == null ) 
                contentEngine.close();
            return is;
        } catch( Throwable e ) {
            Log.e( TAG, u.toString(), e );
        }
        return null;
    }

