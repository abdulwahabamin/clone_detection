    @Override
    public InputStream getContent( Uri u, long offset ) {
        try {
            String zip_path = u.getPath();
            if( zip_path == null ) return null;
            String opened_zip_path = uri != null ? uri.getPath() : null;
            if( opened_zip_path == null )
                zip = new ZipFile( zip_path );
            else if( !zip_path.equalsIgnoreCase( opened_zip_path ) )
                return null;    // do not want to reopen the current zip to something else!
            String entry_name = u.getFragment();
            if( entry_name != null ) {
                cachedEntry = zip.getEntry( entry_name );
                if( cachedEntry != null ) {
                    InputStream is = zip.getInputStream( cachedEntry );
                    if( offset > 0 )
                        is.skip( offset );
                    return is;
                }
            }
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

