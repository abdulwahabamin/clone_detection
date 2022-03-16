    @Override
    public void createFolder( String name ) {
        notify( Commander.OPERATION_STARTED );
        worker = new MkDirEngine( workerHandler, name );
        worker.start();
    }

