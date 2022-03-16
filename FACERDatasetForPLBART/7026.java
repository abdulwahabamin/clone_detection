    @Override
    public String getItemName( int position, boolean full ) {
        if( position < 0 )
            return null;
        if( position == 0 )
            return parentLink;
        try {
            int idx = position - 1;
            if( pkgInfos != null ) {
                return position <= pkgInfos.length ? pkgInfos[idx].packageName : null;
            }
            if( compItems != null ) {
                return position <= compItems.length ? compItems[idx].name : null;
            }
            if( actInfos != null ) {
                return position <= actInfos.length ? actInfos[idx].name : null;
            }
            if( prvInfos != null ) {
                return position <= prvInfos.length ? prvInfos[idx].toString() : null;
            }
            if( srvInfos != null ) {
                return position <= srvInfos.length ? srvInfos[idx].toString() : null;
            }
            if( resInfos != null ) {
                return position <= resInfos.length ? resInfos[idx].toString() : null;
            }
            if( intFilters != null ) {
                return position <= intFilters.length ? intFilters[idx].toString() : null;
            }
        }
        catch( Exception e ) {
            Log.e( TAG, "pos=" + position, e );
        }
        return null;
    }

