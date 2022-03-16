    @Override
    public InputStream getContent( Uri u ) {
            try {
                String path = u.getPath();
                File f = new File( path );
                if( f.exists() && f.isFile() ) {
                    return new FileInputStream( f );
                }
            } catch( Throwable e ) {
                e.printStackTrace();
            }
        return null;
    }

