    @Override
    public Cursor query( Uri uri, String[] as, String s, String[] as1, String s1 ) {
        Log.v( TAG, "query( " + uri + " )" );
        if( uri.toString().startsWith( URI_PREFIX ) ) {
            if( as == null || as.length == 0) {
                as = new String [] {
                    MediaStore.MediaColumns.DATA,
                    MediaStore.MediaColumns.MIME_TYPE,
                    MediaStore.MediaColumns.DISPLAY_NAME,
                    MediaStore.MediaColumns.SIZE };
            } 
            MatrixCursor c = new MatrixCursor( as );
            MatrixCursor.RowBuilder row = c.newRow();
            File f = new File( uri.getPath() );
            if( !f.exists() || !f.isFile() )
                throw new RuntimeException( "No file name specified: " + uri );
            
            for( String col : as ) {
                if( MediaStore.MediaColumns.DATA.equals( col ) ) {
                    row.add( f.getAbsolutePath() );
                } else if( MediaStore.MediaColumns.MIME_TYPE.equals( col ) ) {
                    row.add( getType( uri ) );
                } else if( MediaStore.MediaColumns.DISPLAY_NAME.equals( col ) ) {
                    row.add( f.getName() );
                } else if( MediaStore.MediaColumns.SIZE.equals( col ) ) {
                    row.add( f.length() );
                } else {
                    // Unsupported or unknown columns are filled up with null
                    row.add(null);
                }
            }            
            return c;
        } else
            throw new RuntimeException( "Unsupported URI" );
    }

