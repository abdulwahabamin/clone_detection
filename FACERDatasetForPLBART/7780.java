    @Override
    public boolean renameItem( int position, String newName, boolean copy ) {
        if( position <= 0 || position > items.length )
            return false;
        try {
            LsItem from = items[position - 1];
            String[] a = new String[1];
            a[0] = uri.getPath() + SLS + from.getName();
            String to = uri.getPath() + SLS + newName;
            notify( Commander.OPERATION_STARTED );
            if( copy ) {
                // TODO
                return false;
            }
            
            worker = new CopyToEngine( commander.getContext(), workerHandler, a, true, to, true );
            worker.start();
            return true;
        } catch( Exception e ) {
            notify( "Exception: " + e, Commander.OPERATION_FAILED );
        }
        return false;
    }

