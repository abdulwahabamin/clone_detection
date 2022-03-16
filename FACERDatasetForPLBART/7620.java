    public final void renameItem( String new_name ) {
        CommanderAdapter adapter = getListAdapter( true );
        int pos = getSelection( true );
        if( pos >= 0 ) {
            adapter.renameItem( pos, new_name, false );
            list[current].setSelection( new_name );
        }
    }

