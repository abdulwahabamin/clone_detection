    private final boolean _Save( Uri save_uri )
    {
        if( save_uri == null || ca == null ) return false;
        OutputStream os = ca.saveContent( save_uri );
        if( os == null ) return false;
        try {
            final int BUF_SIZE = 16*1024;
            OutputStreamWriter osw = encoding != null && encoding.length() != 0 ?
                    new OutputStreamWriter( os, encoding ) :
                    new OutputStreamWriter( os );
                    
            Editable e = te.getText();
            int len = e.length();
            if( len < BUF_SIZE ) {
                osw.write( e.toString() );
                osw.flush();
            } else {
                char[] chars = new char[BUF_SIZE];
                int start = 0, end = BUF_SIZE;
                while( start < len-1 ) {
                    e.getChars( start, end, chars, 0 );
                    osw.write( chars, 0, end - start );
                    start = end;
                    end += BUF_SIZE;
                    if( end > len )
                        end = len-1;
                }
            }
            //Log.v( TAG, "Data is sent to the stream" );            
            ca.closeStream( os );
            dirty = false; 
            File f = new File( save_uri.getPath() );
            showMessage( getString( R.string.saved, f.getName() ) );
            return true;
        } catch( Throwable e ) {
            Log.e( TAG, Favorite.screenPwd( save_uri ), e );
        }
        return false;
    }

