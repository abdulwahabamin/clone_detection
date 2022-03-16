    @Override
    public void openItem( int position ) {
        if( position == 0 ) { // ..
            if( uri != null ) {
            	String cur = null; 
            	try {
                    cur = uri.getFragment();
                } catch( Exception e ) {
                }
            	if( cur == null || cur.length() == 0 ||
            	                 ( cur.length() == 1 && cur.charAt( 0 ) == SLC ) ) {
            	    File zip_file = new File( uri.getPath() );
            	    String parent_dir = zip_file.getParent();
            	    commander.Navigate( Uri.parse( parent_dir != null ? parent_dir : Panels.DEFAULT_LOC ), null, 
            	            zip_file.getName() );
            	}
            	else {
            	    File cur_f = new File( cur );
            	    String parent_dir = cur_f.getParent();
            	    commander.Navigate( uri.buildUpon().fragment( parent_dir != null ? parent_dir : "" ).build(), null, cur_f.getName() );
            	}
            }
            return;
        }
        if( items == null || position < 0 || position > items.length )
            return;
        ZipEntry item = items[position - 1];
        
        if( item.isDirectory() ) {
            /*
            String cur = null;    
            try {
                cur = uri.getFragment();
            }
            catch( NullPointerException e ) {}
        	if( cur == null ) 
        	    cur = "";
        	else
        	    if( cur.length() == 0 || cur.charAt( cur.length()-1 ) != SLC )
        	        cur += SLS;
        	*/
            commander.Navigate( uri.buildUpon().fragment( fixName( item ) ).build(), null, null );
        } else {
            commander.Open( uri.buildUpon().fragment( fixName( item ) ).build(), null );
        }
    }

