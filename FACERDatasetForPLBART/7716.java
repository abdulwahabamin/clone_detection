    @Override
    public void openItem( int position ) {
        try {
            if( position == 0 ) {
                commander.Navigate( Uri.parse( RootAdapter.DEFAULT_LOC ), null, null );
                return;
            }
            if( items == null || position < 0 || position > items.length )
                return;
            MountItem item = items[position-1];
            if( isWorkerStillAlive() )
                notify( s( R.string.busy ), Commander.OPERATION_FAILED );
            else {
                worker = new RemountEngine( commander.getContext(), workerHandler, item );
                worker.start();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

