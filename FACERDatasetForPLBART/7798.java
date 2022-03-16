    @Override
    public Item getItem( Uri u ) {
        try {
            ExecEngine ee = new ExecEngine( null, null, null, "ls -l -d " + u.getPath(), false, 100 );
            ee.start();
            StringBuilder sb = null;
            for( int i = 0; i < 10; i++ )
                sb = ee.getResult();
            if( sb == null ) return null;
            LsItem ls_item = new LsItem( sb.toString() );
            Item item = new Item( ls_item.getName() );
            item.size = ls_item.length();
            item.date = ls_item.getDate();
            item.dir = ls_item.isDirectory();
            return item;
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

