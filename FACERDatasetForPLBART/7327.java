	    CopyFromEngine( Handler h, ZipEntry[] list, File dest, int rec_h ) {
	    	super( h );
	    	mList = list;
	        dest_folder = dest;
	        recipient_hash = rec_h;
            try {
                base_pfx = uri.getFragment();
                if( base_pfx == null )
                    base_pfx = "";
                base_len = base_pfx.length(); 
            }
            catch( NullPointerException e ) {
                Log.e( TAG, "", e );
            }
	    }

