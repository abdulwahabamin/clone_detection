    public final static CommanderAdapter CreateAdapterInstance( int type_id, Context c ) {
        CommanderAdapter ca = null;
        if( type_id == FS   ) ca = new FSAdapter( c );    else
        if( type_id == HOME ) ca = new HomeAdapter( c );  else
        if( type_id == ZIP  ) ca = new ZipAdapter( c );   else
        if( type_id == FTP  ) ca = new FTPAdapter( c );   else
        if( type_id == FIND ) ca = new FindAdapter( c );  else
        if( type_id == ROOT ) ca = new RootAdapter( c );  else
        if( type_id == MNT  ) ca = new MountAdapter( c ); else
        if( type_id == APPS ) ca = new AppsAdapter( c );  else
        if( type_id == FAVS ) ca = new FavsAdapter( c );  else
        if( type_id == SMB  ) ca = CreateExternalAdapter( c, "samba",  "SMBAdapter" );
        if( type_id == DBOX ) ca = CreateExternalAdapter( c, "dropbox","DBoxAdapter" );
        return ca;
    }

