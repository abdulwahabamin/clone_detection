    @Override
    protected void reSort() {
        if( items == null ) return;
        ZipItemPropComparator comp = new ZipItemPropComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
        Arrays.sort( items, comp );
    }

