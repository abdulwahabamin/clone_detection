    @Override
    public Object getItem( int position ) {
        Item item = new Item();
        item.name = "";
        {
            if( position == 0 ) {
                item.name = parentLink;
            }
            else {
                if( items != null && position > 0 && position <= items.length ) {
                    ZipEntry zip_entry = items[position - 1];
                    item.dir = zip_entry.isDirectory();
                    String name = fixName( zip_entry );
                    
                    int lsp = name.lastIndexOf( SLC, item.dir ? name.length() - 2 : name.length() );
                    item.name = lsp > 0 ? name.substring( lsp + 1 ) : name;
                    item.size = zip_entry.getSize();
                    long item_time = zip_entry.getTime();
                    item.date = item_time > 0 ? new Date( item_time ) : null;
                }
            }
        }
        return item;
    }

