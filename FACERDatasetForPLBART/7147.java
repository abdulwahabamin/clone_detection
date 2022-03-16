    @Override
    public void populateContextMenu( ContextMenu menu, AdapterView.AdapterContextMenuInfo acmi, int num ) {
        if( num <= 1 ) {
            menu.add( 0, Commander.OPEN, 0, s( R.string.go_button ) );
            menu.add( 0, R.id.F2,        0, s( R.string.rename_title ) );
            menu.add( 0, R.id.F4,        0, s( R.string.edit_title ) );
            menu.add( 0, R.id.F8,        0, s( R.string.delete_title ) );
            menu.add( 0, SCUT_CMD,       0, s( R.string.shortcut ) );
        }
    }    

