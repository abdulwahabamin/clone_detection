    public final void Navigate( int which, Uri uri, Credentials crd, String posTo ) {
    	if( uri == null ) return;
    	String scheme = uri.getScheme(), path = uri.getPath();
    	
    	if( ( scheme == null || scheme.equals( "file") ) && 
    	      ( path == null || !isSafeLocation( path ) ) ) {
    	    if( warnOnRoot ) {
                CommanderAdapter ca = list[which].getListAdapter();
                if( ca != null && CA.FS == ca.getType() ) {
                    String cur_path = ca.toString();
                    if( cur_path != null && isSafeLocation( cur_path ) ) {
                		try {
                    		new NavDialog( c, which, uri, posTo );
            			} catch( Exception e ) {
            				Log.e( TAG, "Navigate()", e );
            			}
            			return;
                    }
                }
    	    }
    	    else if( rootOnRoot )
    	        uri = uri.buildUpon().scheme( "root" ).build();
    	}
    	NavigateInternal( which, uri, crd, posTo );
    }

