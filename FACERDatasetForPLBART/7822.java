        public synchronized void close() {
            try {
                if( ss != null ) {
                    ss.close();
                    ss = null;
                }
                if( stream_thread != null && stream_thread.isAlive() ) {
                    stream_thread.interrupt();
                    stream_thread = null;
                }
            }
            catch( IOException e ) {
                e.printStackTrace();
            }
        }

