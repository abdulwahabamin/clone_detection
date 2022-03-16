    @Override
    public void openItem( int position ) {
        try {
            if( pkgInfos != null  ) {
                if( position == 0 ) {
                    commander.Navigate( Uri.parse( HomeAdapter.DEFAULT_LOC ), null, null );
                }
                else if( position <= pkgInfos.length ) {
                    PackageInfo pi = pkgInfos[position - 1];
                    commander.Navigate( uri.buildUpon().authority( pi.packageName ).build(), null, null );
                }
            } else if( actInfos != null ) {
                if( position == 0 ) {
                    commander.Navigate( uri.buildUpon().path( null ).build(), null, ACTIVITIES );
                }
                else if( position <= actInfos.length ) {
                    ActivityInfo act = actInfos[position-1];
                    if( act.exported )
                        commander.Navigate( uri.buildUpon().appendPath( act.name ).build(), null, null );
                    else
                        commander.showInfo( s( R.string.not_exported ) );
                }
            } else if( prvInfos != null || srvInfos != null ) {
                if( position == 0 ) {
                    commander.Navigate( uri.buildUpon().path( null ).build(), null, PROVIDERS );
                }
                else if( position <= prvInfos.length ) {
                    // ???
                }
            } else if( resInfos != null ) {
                if( position == 0 ) {
                    List<String> paths = uri.getPathSegments();
                    if( paths == null )
                        commander.Navigate( uri.buildUpon().path( null ).build(), null, null );
                    String p = paths.size() > 1 ? paths.get( paths.size()-2 ) : null; 
                    String n = paths.get( paths.size()-1 );
                    commander.Navigate( uri.buildUpon().path( p ).build(), null, n );
                }
                else if( position <= resInfos.length ) {
                    ResolveInfo  ri = resInfos[position - 1];
                    ActivityInfo ai = ri.activityInfo;
                    if( ri.filter.hasAction( Intent.ACTION_CREATE_SHORTCUT ) ) {
                        Intent in = new Intent( Intent.ACTION_CREATE_SHORTCUT );
                        in.setComponent( new ComponentName( ai.packageName, ai.name ) );
                        commander.issue( in, R.id.create_shortcut );
                    }
                    else if( ri.filter.hasAction( Intent.ACTION_MAIN ) ) {
                        Intent in = new Intent(Intent.ACTION_MAIN );
                        in.setComponent( new ComponentName( ai.packageName, ai.name ) );
                        commander.issue( in, 0 );
                        /*
                        Bitmap ico = null;
                        Drawable drawable = ai.loadIcon( pm );
                        if( drawable instanceof BitmapDrawable ) {
                            BitmapDrawable bd = (BitmapDrawable)drawable;
                            ico = bd.getBitmap();
                        }
                        createDesktopShortcut( new ComponentName( ai.packageName, ai.name ), 
                                ai.loadLabel( pm ).toString(), ico );
                        */
                    }
                }
            } else 
            if( intFilters != null ) {
                if( position == 0 ) {
                    List<String> paths = uri.getPathSegments();
                    if( paths == null )
                        commander.Navigate( uri.buildUpon().path( null ).build(), null, null );
                    String p = paths.size() > 1 ? paths.get( paths.size()-2 ) : null; 
                    String n = paths.get( paths.size()-1 );
                    commander.Navigate( uri.buildUpon().path( p ).build(), null, n );
                }
                else {
                    // ???
                }
            } else {
                if( position == 0 ) {
                    commander.Navigate( Uri.parse( DEFAULT_LOC ), null, uri.getAuthority() );
                    return;
                }
                String name = getItemName( position, false );
                if( MANAGE.equals( name ) ) {
                    managePackage( uri.getAuthority() );    
                }
                else if( MANIFEST.equals( name ) ) {
                    String a = uri.getAuthority();
                    ApplicationInfo ai = pm.getApplicationInfo( a, 0 );
                    if( manUtl == null )
                        manUtl = new MnfUtils( pm, a );
                    String m = manUtl.extractManifest();
                    if( m != null ) {
                        Intent in = new Intent( ctx, TextViewer.class );
                        in.setData( Uri.parse( TextViewer.STRURI ) );
                        in.putExtra( TextViewer.STRKEY, m );
                        commander.issue( in, 0 );
                    }
                }
                else 
                    commander.Navigate( uri.buildUpon().path( name ).build(), null, null );
            }
        } catch( Exception e ) {
            Log.e( TAG, uri.toString() + " " + position, e );
        }
    }

