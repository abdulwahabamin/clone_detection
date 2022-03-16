	@Override
    public void createFolder( String dev_mp_pair ) {
        if( isWorkerStillAlive() )
            notify( s( R.string.busy ), Commander.OPERATION_FAILED );
        else {
            worker = new CreateEngine( commander.getContext(), workerHandler, dev_mp_pair );
            worker.start();
        }
	}

