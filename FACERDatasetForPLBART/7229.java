    @Override
    public Object getItem( int position ) {
        Item item = null;
        if( position == 0 ) {
            item = new Item();
            item.name = parentLink;
            item.dir = true;
        }
        else {
            if( items != null && position <= items.length ) {
                synchronized( items ) {
                    try {
                        FileItem f = items[position - 1];
                        item = f;
                        //item.origin = f.f;
                        item.dir  = f.f.isDirectory();
                        if( item.dir ) {
                            if( ( mode & ICON_MODE ) == ICON_MODE )  
                                item.name = f.f.getName() + SLS;
                            else
                                item.name = SLS + f.f.getName();
                        } else
                            item.name = f.f.getName();
                        item.size = item.dir ? f.size : f.f.length();
                        long msFileDate = f.f.lastModified();
                        if( msFileDate != 0 )
                            item.date = new Date( msFileDate );
                        //Log.v( TAG, "getItem(" + (position-1) + ") for " + item.name ); // DEBUG!!!
                    } catch( Exception e ) {
                        Log.e( TAG, "getItem(" + position + ")", e );
                    }
                }
            }
            else {
                item = new Item();
                item.name = "???";
            }
        }
        return item;
    }

