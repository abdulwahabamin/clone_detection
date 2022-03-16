        CopyEngine( Handler h, File[] list, String dest, boolean move_, boolean dest_is_full_name ) {
        	super( h, null );
        	fList = list;
            mDest = dest;
            move = move_;
            destIsFullName = dest_is_full_name;
        }

