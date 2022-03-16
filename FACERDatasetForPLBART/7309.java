    @Override
    public String getItemName( int p, boolean full ) {
        switch( p ) {
        case FAVS:  return s( R.string.favs ); 
        case LOCAL: return s( R.string.local ); 
        case FTP:   return s( R.string.ftp );
        case SMB:   return s( R.string.smb );
        case ROOT:  return s( R.string.root );
        case MOUNT: return s( R.string.mount );
        case APPS:  return s( R.string.apps );
        case EXIT:  return s( R.string.exit );
        }
        return null;
    }

