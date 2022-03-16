	    CopyFromEngine( Handler h, LsItem[] list, File dest, boolean move_, int rec_h ) {
	    	super( h );
	        mList = list;
	        dest_folder = dest;
	        move = move_;
	        recipient_hash = rec_h;
	    }

