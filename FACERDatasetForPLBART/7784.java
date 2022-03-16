    @Override
    public void populateContextMenu( ContextMenu menu, AdapterView.AdapterContextMenuInfo acmi, int num ) {
        super.populateContextMenu( menu, acmi, num );
        try {
            if( acmi.position > 0 )
                menu.add( 0, CHMOD_CMD, 0, R.string.perms_label );
            menu.add( 0, CMD_CMD, 0, commander.getContext().getString( R.string.execute_command ) ); 
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }    

