    @Override
    public boolean readSource( Uri tmp_uri, String pbod ) {
        try {
            dirty = true;
            numItems = 1;
            compItems = null;            
            pkgInfos = null;
            actInfos = null;
            prvInfos = null;
            srvInfos = null;
            resInfos = null;
            intFilters = null;
            super.setMode( ATTR_ONLY, 0 );
            if( reader != null ) {
                if( reader.reqStop() ) { // that's not good.
                    Thread.sleep( 500 );      // will it end itself?
                    if( reader.isAlive() ) {
                        Log.e( TAG, "Busy!" );
                        return false;
                    }
                }
            }
            if( tmp_uri != null )
                uri = tmp_uri;
            String a = uri.getAuthority(); 
            if( a == null || a.length() == 0 ) {    // enumerate the applications
                manUtl = null;
                notify( Commander.OPERATION_STARTED );
                reader = new ListEngine( readerHandler, pbod );
                reader.start();
                
                return true;
            }
            String path = uri.getPath();
            if( path == null || path.length() <= 1 ) {
                ArrayList<Item> ial = new ArrayList<Item>(); 
                numItems = 1;
                Item manage_item = new Item( MANAGE );
                manage_item.setIcon( pm.getApplicationIcon( "com.android.settings" ) );
                manage_item.icon_id = R.drawable.and;
                ial.add( manage_item );
                Item manifest_item = new Item( MANIFEST );
                manifest_item.icon_id = R.drawable.xml;
                ial.add( manifest_item );
                PackageInfo pi = pm.getPackageInfo( a, PackageManager.GET_ACTIVITIES | 
                                                       PackageManager.GET_PROVIDERS | 
                                                       PackageManager.GET_SERVICES );
                if( pi.activities != null && pi.activities.length > 0 ) {
                    Item activities_item = new Item( ACTIVITIES );
                    activities_item.dir = true;
                    activities_item.size = pi.activities.length;
                    ial.add( activities_item );
                }
                if( pi.providers != null && pi.providers.length > 0 ) {
                    Item providers_item = new Item( PROVIDERS );
                    providers_item.dir = true;
                    providers_item.size = pi.providers.length;
                    ial.add( providers_item );
                }
                if( pi.services != null && pi.services.length > 0 ) {
                    Item services_item = new Item( SERVICES );
                    services_item.dir = true;
                    services_item.size = pi.services.length;
                    ial.add( services_item );
                }
                Item shortcuts_item = new Item( SHORTCUTS );
                shortcuts_item.dir = true;
                ial.add( shortcuts_item );
                
                // all items were created
                
                compItems = new Item[ial.size()];
                ial.toArray( compItems );
                numItems = compItems.length + 1;
                notify( pbod );
                return true;
            }
            else { // the URI path contains something
                super.setMode( 0, ATTR_ONLY );
                List<String> ps = uri.getPathSegments();
                if( ps != null && ps.size() >= 1 ) {
                    if( SHORTCUTS.equals( ps.get( 0 ) ) ) {
                        Intent[] ins = new Intent[2];  
                        ins[0] = new Intent( Intent.ACTION_CREATE_SHORTCUT );
                        ins[1] = new Intent( Intent.ACTION_MAIN );
                        resInfos = getResolvers( ins, a );
                        if( resInfos != null )
                            numItems = resInfos.length + 1;
                    } else 
                    if( ps.size() >= 2 && ACTIVITIES.equals( ps.get( 0 ) ) ) {
                        if( manUtl == null )
                            manUtl = new MnfUtils( pm, a );
                        intFilters = manUtl.getIntentFilters( ps.get( 1 ) );
                        if( intFilters != null )
                            numItems = intFilters.length + 1;
                    } else {
                        PackageInfo pi = pm.getPackageInfo( a, PackageManager.GET_ACTIVITIES | 
                                                               PackageManager.GET_PROVIDERS | 
                                                               PackageManager.GET_SERVICES );
                        if( ACTIVITIES.equals( ps.get( 0 ) ) ) {
                            actInfos = pi.activities != null ? pi.activities : new ActivityInfo[0];
                            reSort();
                            numItems = actInfos.length + 1;
                        } else if( PROVIDERS.equals( ps.get( 0 ) ) ) {
                            prvInfos = pi.providers != null ? pi.providers : new ProviderInfo[0];
                            numItems = prvInfos.length + 1;
                        } else if( SERVICES.equals( ps.get( 0 ) ) ) {
                            srvInfos = pi.services != null ? pi.services : new ServiceInfo[0];
                            numItems = srvInfos.length + 1;
                        }
                    }
                    notify( pbod );
                    return true;
                }
            }
        }
        catch( Exception e ) {
            Log.e( TAG, uri != null ? uri.toString() : null, e );
            notify( uri != null ? s( R.string.failed ) + s( R.string.pkg_name ) + ":\n" + uri.getAuthority() : 
                                  s( R.string.fail ), pbod );
            return false;
        }
        finally {
            notifyDataSetChanged();
        }
        notify( s( R.string.fail ), pbod );
        return false;
    }

