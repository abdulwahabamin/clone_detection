        private final long addToList( File[] sub_list, ArrayList<File> full_list ) {
            long total_size = 0;
            try {
                for( int i = 0; i < sub_list.length; i++ ) {
                    if( stop || isInterrupted() ) {
                        errMsg = "Canceled";
                        break;
                    }
                    File f = sub_list[i];
                    if( f != null && f.exists() ) {
                        if( f.isFile() ) {
                            total_size += f.length();
                            full_list.add( f );
                        }
                        else
                        if( f.isDirectory() ) {
                            long dir_sz = addToList( f.listFiles(), full_list );
                            if( errMsg != null ) break;
                            if( dir_sz == 0 )
                                full_list.add( f );
                            else
                                total_size += dir_sz; 
                        }
                    }
                }
            }
            catch( Exception e ) {
                Log.e( TAG, "addToList()", e );
                errMsg = "Exception: " + e.getMessage();
            }
            return total_size;
        }

