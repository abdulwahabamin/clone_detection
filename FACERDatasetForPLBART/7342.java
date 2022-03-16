        @Override
        public void run() {
            int num_files = 0;
            try {
                Init( null );
                sendProgress( prep, 1, 1 );
                ArrayList<File> full_list = new ArrayList<File>( topList.length );
                totalSize = addToList( topList, full_list );
                sendProgress( prep, 2, 2 );
                num_files = addFilesToZip( full_list );
                if( del_src_dir ) {
                    File src_dir = topList[0].getParentFile();
                    if( src_dir != null )
                        src_dir.delete();
                }
            } catch( Exception e ) {
                error( "Exception: " + e.getMessage() );
            }
    		sendResult( Utils.getOpReport( ctx, num_files, R.string.packed ) );
            super.run();
        }

