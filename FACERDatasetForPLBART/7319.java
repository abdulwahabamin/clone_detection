        @Override
        public void run() {
            try {
            	if( uri != null ) {
            	    String zip_path = uri.getPath(); 
                	if( zip_path != null ) {
                  	    zip = new ZipFile( zip_path );
                    	String cur_path = null;
                    	try {
                    	    cur_path = uri.getFragment();
                    	}
                    	catch( NullPointerException e ) {
                    	    // it happens only when the Uri is built by Uri.Builder
                    	    Log.e( TAG, "uri.getFragment()", e );
                    	}
                	    items_tmp = GetFolderList( cur_path );
                	    if( items_tmp != null ) { 
                            ZipItemPropComparator comp = new ZipItemPropComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
                            Arrays.sort( items_tmp, comp );
                            sendProgress( null, Commander.OPERATION_COMPLETED, pass_back_on_done );
                            return;
                	    }
                	}
                }
            }
            catch( Exception e ) {
                Log.e( TAG, "ListEngine", e );
            }
            finally {
            	super.run();
            }
            sendProgress( "Can't open this ZIP file", Commander.OPERATION_FAILED, pass_back_on_done );
        }

