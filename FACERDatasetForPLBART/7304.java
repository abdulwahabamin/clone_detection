    @Override
    public void openItem( int position ) {
        position = translatePosition( position );
        if( position < 0 || position > LAST )
            return;
        String uri_s = null;
        switch( position ) {
        case FAVS:  uri_s = "favs:";                    break; 
        case LOCAL: uri_s = Panels.DEFAULT_LOC;         break; 
        case ROOT:  uri_s = RootAdapter.DEFAULT_LOC;    break;
        case MOUNT: uri_s = MountAdapter.DEFAULT_LOC;   break;
        case APPS:  uri_s = "apps:";                    break;
        case FTP:   commander.dispatchCommand( FileCommander.FTP_ACT ); return;
        case SMB:   commander.dispatchCommand( FileCommander.SMB_ACT ); return;
        case EXIT:  commander.dispatchCommand( R.id.exit ); return;
        }
        commander.Navigate( Uri.parse( uri_s ), null, null );
    }

