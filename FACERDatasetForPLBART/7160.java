    private final int getDrawableIconId( Uri uri ) {
        if( uri != null ) {
            String sch = uri.getScheme();
            if( sch != null && sch.length() != 0 ) {
                int t_id = CA.GetAdapterTypeId( sch );
                if( CA.ZIP  == t_id ) return R.drawable.zip;     else   
                if( CA.FTP  == t_id ) return R.drawable.server;  else   
                if( CA.ROOT == t_id ) return R.drawable.root;    else  
                if( CA.MNT  == t_id ) return R.drawable.mount;   else  
                if( CA.SMB  == t_id ) return R.drawable.smb;     else
                if( CA.HOME == t_id ) return R.drawable.icon;    else
                    return R.drawable.folder;
            }
        }
        return R.drawable.folder;
    }

