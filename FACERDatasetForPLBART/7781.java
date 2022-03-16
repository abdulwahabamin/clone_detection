    @Override
    public Object getItem( int position ) {
        Item item = new Item();
        item.name = "???";
        {
            if( position == 0 ) {
                item.name = parentLink;
            }
            else {
                if( items != null && position > 0 && position <= items.length ) {
                    LsItem curItem;
                    curItem = items[position - 1];
                    item.dir = curItem.isDirectory();
                    item.name = item.dir ? SLS + curItem.getName() : curItem.getName();
                    String lnk = curItem.getLinkTarget();
                    if( lnk != null ) 
                        item.name += " -> " + lnk; 
                    
                    item.size = curItem.isDirectory() ? -1 : curItem.length();
                    item.date = curItem.getDate();
                    item.attr = curItem.getAttr();

                    if( ".apk".equals( Utils.getFileExt( item.name ) ) ) {
                        try {
                            PackageManager pm = ctx.getPackageManager();
                            String path = Utils.mbAddSl( uri.getPath() );
                            PackageInfo info = pm.getPackageArchiveInfo( path + item.name, 0 );
                            item.setIcon( info != null ? pm.getApplicationIcon( info.packageName ) :
                                                           pm.getDefaultActivityIcon() );
                        }
                        catch( Exception e ) {
                        }
                    }                    
                    
                }
            }
        }
        return item;
    }

