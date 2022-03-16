    public final int getSelection( boolean one_checked ) {
        int pos = flv.getSelectedItemPosition();
        if( pos != AdapterView.INVALID_POSITION )
            return currentPosition = pos;
        if( one_checked && getNumItemsChecked() == 1 ) {
            SparseBooleanArray cis = flv.getCheckedItemPositions();
            for( int i = 0; i < cis.size(); i++ )
                if( cis.valueAt( i ) )
                    return cis.keyAt( i );
        }
        return currentPosition;
    }

