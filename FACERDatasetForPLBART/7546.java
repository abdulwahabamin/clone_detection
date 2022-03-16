    public final SparseBooleanArray getSelectedOrChecked() {
        int num_checked = getNumItemsChecked();
        SparseBooleanArray cis;
        if( num_checked > 0 )
            cis = flv.getCheckedItemPositions();
        else {
            cis = new SparseBooleanArray( 1 );
            cis.put( getSelection( false ), true );
        }
        return cis;
    }

