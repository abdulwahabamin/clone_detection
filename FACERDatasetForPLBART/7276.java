        @Override
        public void run() {
            synchronized( ftp ) {
                ftp.clearLog();
                try {
                    if( ftp != null  && ftp.isLoggedIn() ) {
                        synchronized( ftp ) {
                            if( !ftp.rename( oldName, newName ) )
                                error( ctx.getString( R.string.failed ) + ftp.getLog() );
                            sendResult( "" );
                            return;
                        }
                    }
                } catch( Exception e ) {
                    e.printStackTrace();
                }
            }
        }

