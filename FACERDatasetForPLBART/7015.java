    @Override
    public void reqItemsSize( SparseBooleanArray cis ) {
        ArrayList<PackageInfo> pl = null;
        if( pkgInfos == null ) {
            pl = new ArrayList<PackageInfo>( 1 );
            try {
                pl.add( pm.getPackageInfo( uri.getAuthority(), 0 ) );
            } catch( Exception e ) {
                Log.e( TAG, uri.getAuthority(), e );
            }
        }
        else
           pl = bitsToItems( cis, pkgInfos );
        if( pl == null || pl.size() == 0 ) {
            notErr();
            return;
        }
        final String cs = ": ";
        StringBuffer sb = new StringBuffer( 1024 );
        for( int i = 0; i < pl.size(); i++ ) {
            try {
                PackageInfo pi = pm.getPackageInfo( pl.get( i ).packageName, PackageManager.GET_GIDS | 
                                                                             PackageManager.GET_PERMISSIONS |
                                                                             PackageManager.GET_SIGNATURES );
                if( pi == null )
                    continue;
                String v = null;
                int    vc = 0;
                String size = null;
                String date = null;
                String flags = null;
                String gids = null;            
                try {
                    v  = pi.versionName;
                    vc = pi.versionCode;
                    if( pi.gids != null && pi.gids.length > 0 ) {
                        StringBuffer gsb = new StringBuffer( 128 );
                        for( int gi = 0; gi < pi.gids.length; gi++ ) {
                            if( gi > 0 )
                                gsb.append( ", " );
                            int g = pi.gids[gi];
                            gsb.append( g ).append( "(" ).append( getGroupName( g ) ).append( ")" );
                        }
                        gids = gsb.toString();
                    }
                    
                } catch( Exception e ) {}

                sb.append( s( R.string.pkg_name ) ).append( cs ).append( pi.packageName );
                if( v != null ) 
                  sb.append( "\n" ).append( s( R.string.version ) ).append( cs ).append( v );
                if( vc > 0 )
                  sb.append( "\n" ).append( s( R.string.version_code ) ).append( cs ).append( vc );
                
                ApplicationInfo ai = pi.applicationInfo;
                if( ai != null ) {
                    File asdf = new File( ai.sourceDir );
                    date = getLocalDateTimeStr( new Date( asdf.lastModified() ) );
                    size = Utils.getHumanSize( asdf.length() );
                    StringBuffer fsb = new StringBuffer( 512 );
                    int ff = ai.flags;
                    for( int fi = 0; fi < flagsStrs.length; fi++ ) {
                        if( ( ( 1<<fi ) & ff ) != 0 ) {
                            if( fsb.length() > 0 )
                                fsb.append( " | " );
                            fsb.append( flagsStrs[fi] );
                        }
                    }
                    fsb.append( " (" ).append( Integer.toHexString( ff ) ).append( ")" );
                    flags = fsb.toString();

                    sb.append( "\n" ).append( s( R.string.target_sdk ) ).append( cs ).append( ai.targetSdkVersion );
                    sb.append( "\n" ).append( "UID" ).append( cs ).append( ai.uid );
                    if( gids != null )
                      sb.append( "\n" ).append( "GIDs" ).append( cs ).append( gids );
                    sb.append( "\n" ).append( s( R.string.location ) ).append( cs ).append( ai.sourceDir );
                    if( date != null )
                      sb.append( "\n" ).append( s( R.string.inst_date ) ).append( cs ).append( date );
                    if( size  != null )
                      sb.append( "\n" ).append( s( R.string.pkg_size ) ).append( cs ).append( size );
                    sb.append( "\n" ).append( s( R.string.process ) ).append( cs ).append( ai.processName );
                    if( ai.className != null )
                      sb.append( "\n" ).append( s( R.string.app_class ) ).append( cs ).append( ai.className );
                    if( ai.taskAffinity != null )
                      sb.append( "\n" ).append( s( R.string.affinity ) ).append( cs ).append( ai.taskAffinity );
                }
                StringBuffer psb = new StringBuffer( 512 );
                if( pi.requestedPermissions != null ) {
                    for( int rpi = 0; rpi < pi.requestedPermissions.length; rpi++ ) {
                        if( rpi > 0 )
                            psb.append( ", " );
                        String p = pi.requestedPermissions[rpi];
                        if( p.startsWith( "android.permission." ) )
                            p = p.substring( 19 );
                        psb.append( p );
                    }
                }
                if( pi.permissions != null ) {
                    psb.append( "\nDeclared:\n" );
                    for( int dpi = 0; dpi < pi.permissions.length; dpi++ ) {
                        if( dpi > 0 )
                            psb.append( ", " );
                        psb.append( pi.permissions[dpi].toString() );
                    }
                }
                
                if( psb.length() > 0 )
                  sb.append( "\n" ).append( s( R.string.permissions ) ).append( cs ).append( psb.toString() );
                if( flags != null )
                  sb.append( "\n\n" ).append( s( R.string.flags ) ).append( cs ).append( flags );
                sb.append( "\n" );
                if( pi.signatures != null ) {
                    sb.append( "\nSignatures:\n" );
                    for( int si = 0; si < pi.signatures.length; si++ ) {
                        if( si > 0 )
                            sb.append( ", " );
                        sb.append( pi.signatures[si].toCharsString() );
                    }
                }
                
            }
            catch( Exception e ) {
                e.printStackTrace();
            }
        }
        notify( sb.toString(), Commander.OPERATION_COMPLETED, Commander.OPERATION_REPORT_IMPORTANT );
    }

