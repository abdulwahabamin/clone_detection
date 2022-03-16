    public void execute( String command, boolean bb ) {
        if( isWorkerStillAlive() )
            notify( "Busy", Commander.OPERATION_FAILED );
        else {
            worker = new ExecEngine( commander.getContext(), workerHandler, uri.getPath(), command, bb, 500 );
            worker.start();
        }
    }

