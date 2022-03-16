        @Override
        public void run() {
            String cmd = null;
            try {
                cmd = "mount " + pair;
                execute( cmd, true, 500 );
            }
            catch( Exception e ) {
                Log.e( TAG, "mount, ", e );
                error( "Exception: " + e );
            }
            finally {
                super.run();
                sendResult( errMsg != null ? ( cmd == null ? "" : "Were tried to execute: '" + cmd + "'") : null );
            }
        }

