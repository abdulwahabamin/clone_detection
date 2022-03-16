    @Override
    protected void reSort() {
        if( favs == null ) return;
        FavoriteComparator comp = new FavoriteComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
        Collections.sort( favs, comp );
    }

