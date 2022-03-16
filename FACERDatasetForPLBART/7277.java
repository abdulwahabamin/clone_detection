	@Override
	public void prepareToDestroy() {
	    if( heartBeat != null ) {
    		heartBeat.cancel();
    		heartBeat.purge();
    		heartBeat = null;
	    }
        super.prepareToDestroy();
        
		new Thread( new Runnable() {
                @Override
                public void run() {
                    ftp.disconnect( false );
                }
            }, "FTP disconnect" ).start();
		items = null;
	}

