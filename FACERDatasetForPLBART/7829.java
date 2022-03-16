        public synchronized byte[] getOutputBuffer() throws InterruptedException {
            int wcount = 0;
            Log( "       ?.." );
            while( out_buf == null && this.isAlive() ) {
                //Log( "Waiting when the output buffer is ready" );
                wait( 10 );
                wcount += 10;
            }
            if( out_buf != null ) 
                Log( "      ..! (" + wcount + "ms)" );
            else
                Log( "X" );
            return out_buf;
        }

