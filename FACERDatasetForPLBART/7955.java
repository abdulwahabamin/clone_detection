    public final static File[] getListOfFiles( String[] uris ) {
        File[] list = new File[uris.length];
        for( int i = 0; i < uris.length; i++ ) {
            if( uris[i] == null )
                return null;
            list[i] = new File( uris[i] );
        }
        return list;
    }

