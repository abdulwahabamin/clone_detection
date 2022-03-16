	    CopyFromEngine( Context ctx, Handler h, LsItem[] list_, String dest, boolean move_, int recipient_h ) {
	    	super( ctx, h );
	        list = list_;
	        dest_folder = dest;
	        move = move_;
	        src_base_path = uri.getPath();
	        if( src_base_path == null || src_base_path.length() == 0 )
	            src_base_path = SLS;
	        else
	        if( src_base_path.charAt( src_base_path.length()-1 ) != SLC )
	            src_base_path += SLS;
	        recipient_hash = recipient_h;
	        if( recipient_hash != 0 )
                try {
        	        PackageManager pm = ctx.getPackageManager();
        	        if( pm != null ) {
        	            ApplicationInfo ai;
                        ai = pm.getApplicationInfo( ctx.getPackageName(), 0 );
                        if( ai != null )
                            uid = "" + ai.uid;
        	        }
        	    } catch( NameNotFoundException e ) {
                    e.printStackTrace();
                }
	    }

