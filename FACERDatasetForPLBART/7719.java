    @Override
    public Object getItem( int position ) {
        Item item = new Item();
        if( position == 0 ) {
            item = new Item();
            item.name = parentLink;
            item.dir = true;
        }
        else {
            item.name = "???";
            if( items != null && position > 0 && position <= items.length ) {
                MountItem curItem = items[position - 1];
                if( curItem != null ) {
                    String mp = curItem.getMountPoint();
                    if( mp != null ) {
                        if( "/system".equals( mp ) )
                            item.icon_id = R.drawable.application;
                        else if( mp.contains( "/sdcard" ) )
                            item.icon_id = R.drawable.sd;
                    }
                    item.dir = false;
                    item.name = curItem.getName();
                    item.size = -1;
                    item.sel = false;
                    item.date = null;
                    item.attr = curItem.getRest();
                }
            }
        }
        return item;
    }

