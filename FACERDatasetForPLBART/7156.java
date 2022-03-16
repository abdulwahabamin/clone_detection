    @Override
    public void doIt( int command_id, SparseBooleanArray cis ) {
        if( SCUT_CMD == command_id ) {
            int k = 0, n = favs.size();
            for( int i = 0; i < cis.size(); i++ ) {
                k = cis.keyAt( i );
                if( cis.valueAt( i ) && k > 0 && k <= n )
                    break;
            }
            if( k > 0 )
                createDesktopShortcut( favs.get( k - 1 ) );
        }
    }

