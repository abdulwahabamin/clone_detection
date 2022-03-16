    @Override
    public String getItemName( int p, boolean full ) {
        if( favs != null && p > 0 && p <= favs.size() ) {
            Favorite f = favs.get( p - 1 );
            String comm = f.getComment();
            return comm != null && comm.length() > 0 ? comm : full ? f.getUriString( true ) : "";
        }
        return null;
    }

