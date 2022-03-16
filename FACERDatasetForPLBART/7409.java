        @Override
        protected Boolean doInBackground( Uri... save_uri_ ) {
            Uri save_uri = save_uri_.length > 0 ? save_uri_[0] : null;
            if( save_uri == null || Editor.this.ca == null ) return false;
            OutputStream os = Editor.this.ca.saveContent( save_uri );
            if( os == null ) return false;
            try {
                final int BUF_SIZE = 16*1024;
                OutputStreamWriter osw = Editor.this.encoding != null && Editor.this.encoding.length() != 0 ?
                        new OutputStreamWriter( os, Editor.this.encoding ) :
                        new OutputStreamWriter( os );
                        
                Editable e = Editor.this.te.getText();
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
                Editor.this.ca.closeStream( os );
                 
                File f = new File( save_uri.getPath() );
                publishProgress( getString( R.string.saved, f.getName() ) );
                return true;
            } catch( Throwable e ) {
                Log.e( TAG, Favorite.screenPwd( save_uri ), e );
            }
            return false;
        }

