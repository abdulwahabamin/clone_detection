	    @Override
	    public void run() {
	    	int total = copyFiles( mList, "" );
            if( recipient_hash != 0 ) {
                sendReceiveReq( recipient_hash, dest_folder );
                return;
            }
			sendResult( Utils.getOpReport( ctx, total, R.string.unpacked ) );
	        super.run();
	    }

