        public void run() {
            try {
                //setPriority( Thread.MAX_PRIORITY );
                setPriority( Thread.NORM_PRIORITY );
                int count = 0;
                while( true ) {
                    byte[] inp_buf = bufs[roller++ % 2];
                    Log( "R..." );
                    int has_read = is.read( inp_buf, 0, chunk );
                    if( has_read < 0 )
                        break;
                    if( has_read == chunk && chunk < MAX )
                        chunk <<= 1;
                    if( chunk > MAX )
                        chunk = MAX;                    
                    Log( "...R " + has_read + "/" + ( count += has_read ) );
                    synchronized( this ) {
                        Log( "?.." );
                        int wcount = 0; 
                        while( out_buf != null ) {
                            //Log( "Waiting when the output buffer is released..." );
                            wait( 10 );
                            wcount += 10;
                        }
                        Log( "...! (" + wcount + "ms)" );
                        out_buf = inp_buf;
                        data_size = has_read; 
                        Log( "O=I ->" );
                        notify();
                    }
                }
            } catch( Throwable e ) {
                Log.e( TAG, "Exception: " + e );
            }
            Log( "The thread is done!" );
        }

