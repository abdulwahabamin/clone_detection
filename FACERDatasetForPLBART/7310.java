    @Override
    public Object getItem( int position ) {
        Utils.changeLanguage( ctx );
        position = translatePosition( position );
        Item item = new Item();
        item.name = "???";
        if( position >= 0 && position <= LAST ) {
            item.name = getItemName( position, false );
             
            switch( position ) {
            case FAVS:  item.icon_id = R.drawable.favs;     break;  
            case LOCAL: item.icon_id = R.drawable.sd;       break;  
            case FTP:   item.icon_id = R.drawable.ftp;      break;
            case SMB:   item.icon_id = R.drawable.smb;      break;
            case ROOT:  item.icon_id = R.drawable.root;     break;
            case MOUNT: item.icon_id = R.drawable.mount;    break;
            case EXIT:  item.icon_id = R.drawable.exit;     break;
            case APPS:  item.icon_id = R.drawable.android;  break;
            }
            switch( position ) {
            case FAVS:  item.attr = s( R.string.favs_descr  ); break;  
            case LOCAL: item.attr = s( R.string.local_descr ); break;  
            case FTP:   item.attr = s( R.string.ftp_descr   ); break;
            case SMB:   item.attr = s( R.string.smb_descr   ); break;
            case ROOT:  item.attr = s( R.string.root_descr  ); break;
            case MOUNT: item.attr = s( R.string.mount_descr ); break;
            case EXIT:  item.attr = s( R.string.exit_descr  ); break;
            case APPS:  item.attr = s( R.string.apps_descr  ); break;
            }
        }
        return item;
    }

