    public final void setSelection( String name ) {
        CommanderAdapter ca = (CommanderAdapter)flv.getAdapter();
        if( ca != null ) {
            int i, num = ( (ListAdapter)ca ).getCount();
            for( i = 0; i < num; i++ ) {
                String item_name = ca.getItemName( i, false );
                if( item_name != null && item_name.compareTo( name ) == 0 ) {
                    Log.v( TAG, "trying to set panel " + which + " selection to '" + name + "', pos: " + i + ", ph: " + flv.getHeight() );
                    setSelection( i, flv.getHeight() / 2 );
                    break;
                }
            }
        }
    }

