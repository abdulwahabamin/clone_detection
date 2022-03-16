    @Override
    public Object getItem( int position ) {
        try {
            Object o = super.getItem( position );
            if( o != null ) {
                if( o instanceof FileItem ) {
                    FileItem fi = (FileItem)o;
                    fi.name = fi.f.getAbsolutePath();
                }
                return o;
            }
        } catch( Exception e ) {
            Log.e( TAG, "getItem() Exception" );
        }
        return null;
    }    

