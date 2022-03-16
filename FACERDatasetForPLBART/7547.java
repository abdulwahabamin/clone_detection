    public final String getActiveItemsSummary() {
        int counter = getNumItemsChecked();
        if( counter > 1 ) {
            String items = null;
            if( counter < 5 )
                items = p.c.getString( R.string.items24 );
            if( items == null || items.length() == 0 )
                items = p.c.getString( R.string.items );
            return "" + counter + " " + items;
        }
        CommanderAdapter adapter = (CommanderAdapter)flv.getAdapter();
        if( counter == 1 ) {
            SparseBooleanArray cis = flv.getCheckedItemPositions();
            for( int i = 0; i < cis.size(); i++ )
                if( cis.valueAt( i ) ) {
                    String item_name = adapter.getItemName( cis.keyAt( i ), false );
                    if( item_name == null || item_name.length() == 0 )
                        item_name = adapter.getItemName( cis.keyAt( i ), true );
                    return "\"" + item_name + "\"";
                }
        }
        int cur_sel = getSelection( false );
        if( cur_sel <= 0 )
            return null; // the topmost item is also invalid
        String item_name = adapter.getItemName( cur_sel, false ); 
        if( item_name == null || item_name.length() == 0 )
            item_name = adapter.getItemName( cur_sel, true );
        return "\"" + item_name + "\"";
    }

