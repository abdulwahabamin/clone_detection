    private final boolean getList( boolean su ) {
        if( !su ) sh = "sh";
        if( !execute( "mount", false, 500 ) ) return false;

        int sz = array.size();
        items_tmp = new MountItem[sz];
        if( sz > 0 )
            array.toArray( items_tmp );
        return true;
    }        

