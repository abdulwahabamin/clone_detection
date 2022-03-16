    @Override
    public boolean copyItems( SparseBooleanArray cis, CommanderAdapter to, boolean move ) {
        if( pkgInfos != null ) { 
            ArrayList<PackageInfo> pl = bitsToItems( cis, pkgInfos );
            if( pl == null || pl.size() == 0 ) {
                notify( s( R.string.copy_err ), Commander.OPERATION_FAILED );
                return false;
            }
            String[] paths = new String[pl.size()];
            for( int i = 0; i < pl.size(); i++ ) {
                ApplicationInfo ai = pl.get( i ).applicationInfo;
                if( ai != null )
                    paths[i] = ai.sourceDir;
            }
            
            boolean ok = to.receiveItems( paths, MODE_COPY );
            if( !ok ) notify( Commander.OPERATION_FAILED );
            return ok;
        }
        if( compItems != null ) {
            ArrayList<Item> il = bitsToItems( cis, compItems );
            if( il != null ) {
                for( int i = 0; i < il.size(); i++ ) {
                    if( MANIFEST.equals( il.get( i ).name ) ) {
                        try {
                            ApplicationInfo ai = pm.getApplicationInfo( uri.getAuthority(), 0 );
                            if( manUtl == null )
                                manUtl = new MnfUtils( pm, ai.packageName );
                            String m = manUtl.extractManifest();
                            if( m != null && m.length() > 0 ) {
                                String tmp_fn = ai.packageName + ".xml";
                                FileOutputStream fos = ctx.openFileOutput( tmp_fn, Context.MODE_WORLD_WRITEABLE|Context.MODE_WORLD_READABLE);
                                if( fos != null ) {
                                    OutputStreamWriter osw = new OutputStreamWriter( fos );
                                    osw.write( m );
                                    osw.close();
                                    String[] paths = new String[1];
                                    paths[0] = ctx.getFileStreamPath( tmp_fn ).getAbsolutePath();
                                    boolean ok = to.receiveItems( paths, MODE_COPY );
                                    if( !ok ) notify( Commander.OPERATION_FAILED );
                                    return ok;
                                }
                            }
                        } catch( Exception e ) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return notErr();
    }

