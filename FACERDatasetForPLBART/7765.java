    @Override
    public void createFolder( String new_name ) {
        if( uri == null ) return;
        if( isWorkerStillAlive() )
            notify( "Busy", Commander.OPERATION_FAILED );
        else {
            worker = new MkDirEngine( commander.getContext(), workerHandler, new_name );
            worker.start();
        }
    }

