        private final boolean searchInsideFile( File f, String s ) {
            try {
                BufferedReader br = new BufferedReader( new FileReader( f ) ); 
                final  int  l = s.length();
                int    ch = 0;
                int    cnt = 0, p = 0;
                double conv = 100./f.length();
                while( true ) {
                    for( int i = 0; i < l; i++ ) {
                        ch = br.read();
                        if( ch == -1 )
                            return false;
                        if( ch != s.charAt( i ) ) {
                            if( i > 0 )
                                br.reset();
                            break;
                        }
                        if( i == 0 )
                            br.mark( l );
                        if( i >= l-1 )
                            return true;
                    }
                    int np = (int)(cnt++ * conv);
                    if( np - 10 > p )
                        sendProgress( f.getAbsolutePath(), progress, p = np );
                    sleep( 1 );
                }
            }
            catch( InterruptedException e ) {
            }
            catch( Exception e ) {
                Log.e( TAG, "File: " + f.getName() + ", str=" + s, e );
            }
            return false;
        }

