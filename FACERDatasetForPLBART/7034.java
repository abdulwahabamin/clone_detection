    /**
         the mapping between the scheme and the adapter type id 
         ("many-one" - because we could let the user to enter short aliases for the scheme instead)
    */
    public final static int GetAdapterTypeId( String scheme ) {
        if( scheme == null || scheme.length() == 0 ) return FS;
        final int scheme_h = scheme.hashCode();
        if( home_schema_h == scheme_h )  return HOME;
        if(  zip_schema_h == scheme_h )  return ZIP;
        if(  ftp_schema_h == scheme_h )  return FTP;
        if( find_schema_h == scheme_h )  return FIND;
        if( root_schema_h == scheme_h )  return ROOT;
        if(  mnt_schema_h == scheme_h )  return MNT;
        if( apps_schema_h == scheme_h )  return APPS;
        if( favs_schema_h == scheme_h )  return FAVS;
        if(  smb_schema_h == scheme_h )  return SMB;
        if( dbox_schema_h == scheme_h )  return DBOX;
        if(   gd_schema_h == scheme_h )  return GDOCS;
        if(gdocs_schema_h == scheme_h )  return GDOCS;
        return FS;
    }

