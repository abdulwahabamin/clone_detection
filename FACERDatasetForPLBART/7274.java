    @Override
    public boolean renameItem( int position, String new_name, boolean copy ) {
        try {
            if( copy ) {
                notify( s( R.string.not_supported ), Commander.OPERATION_FAILED );
            }
            if( items == null || position <= 0 || position > items.length )
                return false;
            String old_name = getItemName( position, false );
            if( old_name != null ) {
                notify( Commander.OPERATION_STARTED );
                worker = new RenEngine( workerHandler, old_name, new_name );
                worker.start();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

