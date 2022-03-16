    @Override
    public boolean deleteItems( SparseBooleanArray cis ) {
        if( pkgInfos == null ) return notErr();
        ArrayList<PackageInfo> al = bitsToItems( cis, pkgInfos );
        if( al == null ) return false;
        for( int i = 0; i < al.size(); i++ ) {
            Intent in = new Intent( Intent.ACTION_DELETE, Uri.parse( "package:" + al.get( i ).packageName ) );
            commander.issue( in, 0 );
        }
        return true;
    }

