		@Override
		public void run() {
			if( !noHeartBeats && reader == null && worker == null && ftp.isLoggedIn() )
				synchronized( ftp ) {
					try {
					    //Log.v( TAG, "FTP NOOP" );
                        ftp.heartBeat();
                    } catch( InterruptedException e ) {
                        e.printStackTrace();
                    }
				}
		}

