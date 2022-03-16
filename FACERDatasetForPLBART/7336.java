    @Override
    public String getItemName( int position, boolean full ) {
        if( items != null && position > 0 && position <= items.length ) {
            if( full ) {
                if( uri != null ) {
                    Uri item_uri = getItemUri( position );
                    if( item_uri != null )
                        return item_uri.toString();
                }
            }
            else
                return new File( fixName( items[position-1] ) ).getName();
        }
        return null;
    }

