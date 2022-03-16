    public final void checkItems( boolean set, String mask, boolean dir, boolean file ) {
        try {
            if( false == dir && false == file ) return;   // should it issue a warning?
            String[] cards = Utils.prepareWildcard( mask );
            ListAdapter la = flv.getAdapter();
            CommanderAdapter ca = (CommanderAdapter)la;
            if( la != null && cards != null ) {
                for( int i = 1; i < flv.getCount(); i++ ) {
                    if( dir != file ) {
                        CommanderAdapter.Item cai = (CommanderAdapter.Item)la.getItem( i );
                        if( cai == null ) continue;
                        if( cai.dir ) {
                            if( !dir )  continue;
                        } else {
                            if( !file ) continue;
                        }
                    }
                    if( Utils.match( ca.getItemName( i, false ), cards ) )
                        flv.setItemChecked( i, set );
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, mask, e );
        }
    }

