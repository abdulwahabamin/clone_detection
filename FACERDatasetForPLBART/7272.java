        @Override
        public void run() {
            try {
                if( connectAndLogin( uri ) < 0 ) {
                    error( s( R.string.ftp_nologin ) );
                    sendResult( "" );
                    return;
                }

                wifiLock.acquire();
                int total = copyFiles( mList );
                wifiLock.release();
                if( del_src_dir ) {
                    File src_dir = mList[0].getParentFile();
                    if( src_dir != null )
                        src_dir.delete();
                }
                sendResult( Utils.getOpReport( ctx, total, R.string.uploaded ) );
                return;
            } catch( Exception e ) {
                error( "Exception: " + e.getMessage() );
            }
            finally {            
                super.run();
            }
            sendResult( "" );
        }

