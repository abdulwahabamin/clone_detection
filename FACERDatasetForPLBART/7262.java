        @Override
        public void run() {
            synchronized( ftp ) {
                ftp.clearLog();
                try {
                    ftp.makeDir( name );
                    sendResult( "" );
                } catch( Exception e ) {
                }
                error( ctx.getString( R.string.ftp_mkdir_failed, name, ftp.getLog() ) );            
            }
            sendResult( "" );
        }

