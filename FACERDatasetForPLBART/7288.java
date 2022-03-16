    @Override
    public Item getItem( Uri u ) {
        try {
            if( connectAndLogin( u, false ) > 0 ) {
                List<String> segs = u.getPathSegments();
                if( segs.size() == 0 ) {
                    Item item = new Item( "/" );
                    item.dir = true;
                    return item;
                }
                String prt_path = ""; 
                for( int i = 0; i < segs.size()-1; i++ ) {
                    prt_path += "/" + segs.get( i );
                }
                LsItem[] subItems = ftp.getDirList( prt_path );
                if( subItems != null ) {
                    String fn = segs.get( segs.size() - 1 );
                    for( int i = 0; i < subItems.length; i++ ) {
                        LsItem ls_item = subItems[i];
                        String ifn = ls_item.getName();
                        if( fn.equals( ifn ) ) {
                            Item item = new Item( ifn );
                            item.size = ls_item.length();
                            item.date = ls_item.getDate();
                            item.dir = ls_item.isDirectory();
                            return item;
                        }
                    }
                }
            }
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

