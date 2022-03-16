    @Override
    protected void reSort() {
        if( pkgInfos != null ) { 
            PackageInfoComparator comp = new PackageInfoComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
            Arrays.sort( pkgInfos, comp );
        }
        else if( actInfos != null ) {
            ActivityInfoComparator comp = new ActivityInfoComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
            Arrays.sort( actInfos, comp );
        }
        else if( prvInfos != null ) {
        }
        else {
        }
    }

