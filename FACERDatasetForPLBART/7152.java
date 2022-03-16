    @Override
    public boolean deleteItems( SparseBooleanArray cis ) {
        for( int i = 0; i < cis.size(); i++ )
            if( cis.valueAt( i ) ) {
                int k = cis.keyAt( i );
                if( k > 0 ) {
                    favs.remove( k - 1 );
                    numItems--;
                    notifyDataSetChanged();
                    notify( Commander.OPERATION_COMPLETED );
                    return true;
                }
            }
        return false;
    }

