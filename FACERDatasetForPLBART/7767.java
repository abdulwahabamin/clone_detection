        @Override
        public void run() {
            try {
                String cmd = "mkdir " + ExecEngine.prepFileName( full_name );
                execute( cmd, true, 100 );
            } catch( Exception e ) {
                error( "Exception: " + e );
            }
            sendResult( errMsg != null ? "Directory '" + full_name + "' was not created." : null );
        }

