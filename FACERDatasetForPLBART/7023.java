    @Override
    public void doIt( int command_id, SparseBooleanArray cis ) {
        try {
            if( pkgInfos != null ) {
                ArrayList<PackageInfo> pl = bitsToItems( cis, pkgInfos );
                if( pl == null || pl.size() == 0 ) return;
                ApplicationInfo ai = pl.get(0).applicationInfo;
                if( ai == null ) return;
                if( MANAGE_CMD == command_id ) {
                    managePackage( ai.packageName );
                    return;
                }
                if( LAUNCH_CMD == command_id ) {
                    Intent in = pm.getLaunchIntentForPackage( ai.packageName );
                    commander.issue( in, 0 );
                    return;
                }
            }
            else if( resInfos != null ) {
                if( SHRCT_CMD == command_id ) {
                    ArrayList<ResolveInfo> rl = bitsToItems( cis, resInfos );
                    if( rl == null || rl.size() == 0 ) return;
                    for( int i = 0; i < rl.size(); i++ ) {
                        ActivityInfo ai = rl.get( i ).activityInfo;
                        if( ai != null ) {
                            Bitmap ico = null;
                            Drawable drawable = ai.loadIcon( pm );
                            if( drawable instanceof BitmapDrawable ) {
                                BitmapDrawable bd = (BitmapDrawable)drawable;
                                ico = bd.getBitmap();
                            }
                            createDesktopShortcut( new ComponentName( ai.applicationInfo.packageName, ai.name ), 
                                                                      ai.loadLabel( pm ).toString(), ico );
                        }
                    }
                    return;
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, "Can't do the command " + command_id, e );
        }
    }

