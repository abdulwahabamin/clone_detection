    @Override
    public Object getItem( int position ) {
        Item item = new Item();
        if( position == 0 ) {
            item.name = parentLink;
            item.dir = true;
            return item;
        }
        item.name = "???";
        if( pkgInfos != null ) { 
            if( position >= 0 && position <= pkgInfos.length ) {
                PackageInfo pi = pkgInfos[position - 1];
                ApplicationInfo ai = pi.applicationInfo;
                item.dir = false;
                item.name = ai != null ? ai.loadLabel( pm ).toString() : pi.packageName;
                item.sel = false;
                File asdf = new File( ai.sourceDir );
                item.date = new Date( asdf.lastModified() );
                item.size = asdf.length();
                if( ai != null )
                    item.attr = ai.packageName;
                item.setIcon( ai.loadIcon( pm ) );
                item.origin = new File( ai.sourceDir );
            }
        }
        else if( actInfos != null ) {
            if( position <= actInfos.length ) {
                ActivityInfo ai = actInfos[position - 1];
                item.name = ai.loadLabel( pm ).toString();
                if( !ai.exported )
                    item.name += " - private"; 
                item.attr = ai.name;
                item.setIcon( ai.loadIcon( pm ) );
            }
        }
        else if( prvInfos != null ) {
            if( position <= prvInfos.length ) {
                ProviderInfo pi = prvInfos[position - 1];
                item.name = pi.loadLabel( pm ).toString(); 
                item.attr = pi.name;
                item.setIcon( pi.loadIcon( pm ) );
            }
        }
        else if( srvInfos != null ) {
            if( position <= srvInfos.length ) {
                ServiceInfo si = srvInfos[position - 1];
                item.name = si.loadLabel( pm ).toString(); 
                item.attr = si.name;
                item.setIcon( si.loadIcon( pm ) );
            }
        }
        else if( resInfos != null ) {
            try {
                if( position <= resInfos.length ) {
                    ResolveInfo ri = resInfos[position - 1];
                    IntentFilter inf = ri.filter;
                    if( inf != null ) {
                        ActivityInfo ai = ri.activityInfo;
                        item.name = ai.loadLabel( pm ).toString(); 
                        item.attr = ai.name;
                        item.setIcon( ai.loadIcon( pm ) );
                        if( ri.filter.hasAction( Intent.ACTION_CREATE_SHORTCUT )  )
                            item.name += " - CREATE_SHORTCUT";
                        if( ri.filter.hasAction( Intent.ACTION_MAIN ) )
                            item.name += " - MAIN";
                    }
                    else {
                        item.name = ri.loadLabel( pm ).toString();
                        item.attr = ri.toString();
                    }
                    item.setIcon( ri.loadIcon( pm ) );
                }
            }
            catch( Exception e ) {
                Log.e( TAG, "pos=" + position, e );
            }
        }
        else if( intFilters != null ) {
            if( position <= intFilters.length ) {
                IntentFilter inf = intFilters[position - 1];
                String action = inf.getAction( 0 );
                item.name = action != null ? action : inf.toString();
                StringBuilder sb = new StringBuilder( 128 );
                int n = inf.countDataTypes();
                if( n > 0 ) {
                    sb.append( "types=" );
                    for( int i = 0; i< n; i++ ) {
                        if( i != 0 )
                            sb.append( ", " );
                        String dt = inf.getDataType( i ); 
                        sb.append( dt );
                    }
                    sb.append( "; " );
                }
                n = inf.countCategories();
                if( n > 0 ) {
                    sb.append( "categories=" );
                    for( int i = 0; i< n; i++ ) {
                        if( i != 0 )
                            sb.append( ", " );
                        String ct = inf.getCategory( i ); 
                        sb.append( ct );
                    }
                    sb.append( "; " );
                }
                
                n = inf.countDataSchemes();
                if( n > 0 ) {
                    sb.append( "schemes=" );
                    for( int i = 0; i< n; i++ ) {
                        if( i != 0 )
                            sb.append( ", " );
                        String ds = inf.getDataScheme( i ); 
                        sb.append( ds );
                    }
                }
                item.attr = sb.toString();
            }            
        }
        else {
            if( position <= compItems.length )
                return compItems[position-1];
        }
        return item;
    }

