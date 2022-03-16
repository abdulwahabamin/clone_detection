        protected final void searchInFolder( File dir ) throws Exception {
            try {
                String dir_path = dir.getAbsolutePath();
                if( dir_path.compareTo( "/sys" ) == 0 ) return;
                if( dir_path.compareTo( "/dev" ) == 0 ) return;
                if( dir_path.compareTo( "/proc" ) == 0 ) return;
                File[] subfiles = dir.listFiles();
                if( subfiles == null || subfiles.length == 0 )
                    return;
                double conv = 100./subfiles.length;
                for( int i = 0; i < subfiles.length; i++ ) {
                    sleep( 1 );
                    if( stop || isInterrupted() ) 
                        throw new Exception( ctx.getString( R.string.interrupted ) );
                    File f = subfiles[i];
                    int np = (int)(i * conv);
                    if( np == 0 || np - 1 > progress )
                        sendProgress( f.getAbsolutePath(), progress = np );
                    //Log.v( TAG, "Looking at file " + f.getAbsolutePath() );
                    addIfMatched( f );
                    if( !olo && f.isDirectory() ) {
                        if( depth++ > 30 )
                            throw new Exception( ctx.getString( R.string.too_deep_hierarchy ) );
                        searchInFolder( f );
                        depth--;
                    }
                }
            } catch( Exception e ) {
                Log.e( TAG, "Exception on search: ", e );
            }
        }

