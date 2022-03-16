    @Override
    public Item getItem( Uri u ) {
        try {
            String zip_path = u.getPath();
            if( zip_path == null ) return null;
            String opened_zip_path = uri != null ? uri.getPath() : null;
            if( opened_zip_path == null )
                zip = new ZipFile( zip_path );
            else if( !zip_path.equalsIgnoreCase( opened_zip_path ) )
                return null;    // do not want to reopen the current zip to something else!
            String entry_name = u.getFragment();
            if( entry_name != null ) {
                ZipEntry zip_entry = zip.getEntry( entry_name );
                if( zip_entry != null ) {
                    String name = fixName( zip_entry );
                    Item item = new Item();
                    item.dir = zip_entry.isDirectory();
                    int lsp = name.lastIndexOf( SLC, item.dir ? name.length() - 2 : name.length() );
                    item.name = lsp > 0 ? name.substring( lsp + 1 ) : name;
                    item.size = zip_entry.getSize();
                    long item_time = zip_entry.getTime();
                    item.date = item_time > 0 ? new Date( item_time ) : null;
                    return item;
                }
            }
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

