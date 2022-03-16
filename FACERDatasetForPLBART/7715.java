    @Override
    public String getItemName( int position, boolean full ) {
        if( position == 0 ) return SLS;
        if( items != null && position > 0 && position <= items.length ) {
            return items[position-1].getName();
        }
        return null;
    }

