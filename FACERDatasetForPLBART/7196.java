    @Override
    public boolean readSource( Uri d, String pass_back_on_done ) {
    	try {
    	    //if( worker != null ) worker.reqStop();
            File[] files_ = null; 
            String dir_name = null;
            File dir = null;
            String err_msg = null;
            while( true ) {
                if( d != null )
                    dir_name = d.getPath();
                else
                    dir_name = dirName;
                if( dir_name == null ) {
                    notify( s( R.string.inv_path ) + ": " + ( d == null ? "null" : d.toString() ), Commander.OPERATION_FAILED );
                    Log.e( TAG, "Unable to obtain folder of the folder name" );
                    return false;
                }
                //Log.v( TAG, "readSource() path=" + dir_name );                
                dir = new File( dir_name );
                files_ = dir.listFiles();
                if( files_ != null ) break;
                if( err_msg == null )
                    err_msg = ctx.getString( R.string.no_such_folder, dir_name );
                String parent_path;
                if( dir == null || ( parent_path = dir.getParent() ) == null || ( d = Uri.parse( parent_path ) ) == null ) {
                    notify( s( R.string.inv_path ), Commander.OPERATION_FAILED );
                    Log.e( TAG, "Wrong folder '" + dir_name + "'" );
                    return false;
                }
            }
            dirName = dir_name;
            items = filesToItems( files_ );
            parentLink = dir.getParent() == null ? SLS : PLS;
            notifyDataSetChanged();
            startThumbnailCreation();
            notify( pass_back_on_done );
            return true;
        } catch( Exception e ) {
            Log.e( TAG, "readSource() excception", e );
        } catch( OutOfMemoryError err ) {
            Log.e( TAG, "Out Of Memory", err );
            notify( s( R.string.oom_err ), Commander.OPERATION_FAILED );
		}
		return false;
    }

