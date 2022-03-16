    @Override
    public OutputStream saveContent( Uri u ) {
        try {
            if( u == null ) return null;
            String path = u.getPath();
            
            dst_f = new File( path );
            File root_f = ctx.getDir( "root", Context.MODE_PRIVATE );
            if( root_f == null )
                return null;
            tmp_f = new File( root_f, dst_f.getName() );
            return new FileOutputStream( tmp_f );
        } catch( Throwable e ) {
            Log.e( TAG, u.toString(), e );
        }
        return null;
    }

