        public synchronized boolean waitUntilOpen() {
            try {
                for( int i = 0; i < 50; i++ ) {
                    if( open_done )
                        return true;
                    wait( 100 ); 
                }
            } catch( InterruptedException e ) {}
            return false;
        }

