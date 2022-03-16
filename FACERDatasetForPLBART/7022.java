    @Override
    public void populateContextMenu( ContextMenu menu, AdapterView.AdapterContextMenuInfo acmi, int num ) {
        try {
            if( acmi.position > 0 ) { 
                if( pkgInfos != null ) {
                    ApplicationInfo ai = pkgInfos[acmi.position-1].applicationInfo;
                    if( ai != null ) {
                        String name = ai.loadLabel( pm ).toString();
                        menu.add( 0, LAUNCH_CMD, 0, ctx.getString( R.string.launch ) + " \"" + name + "\"" );
                    }
                    menu.add( 0, MANAGE_CMD, 0, MANAGE );
                    menu.add( 0, Commander.SEND_TO, 0, R.string.send_to );
                }
                else if( resInfos != null ) {
                    ResolveInfo ri = resInfos[acmi.position-1];
                    if( ri.filter != null && ri.filter.matchAction( Intent.ACTION_MAIN ) )
                        menu.add( 0, SHRCT_CMD, 0, ctx.getString( R.string.shortcut ) );
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
        super.populateContextMenu( menu, acmi, num );
    }    

