        @Override
        protected boolean cmdDialog( OutputStreamWriter os, BufferedReader is, BufferedReader es ) { 
            try {
                int num = mList.length;
                double conv = 100./num;
                for( int i = 0; i < num; i++ ) {
                    LsItem f = mList[i];
                    String full_name = src_base_path + f.getName();
                    sendProgress( "Deleting " + full_name, (int)(counter * conv) );
                    String to_exec = "rm " + ( f.isDirectory() ? "-r " : "" ) + prepFileName( full_name );
                    outCmd( false, to_exec, os );
                    if( procError( es ) ) return false;
                    counter++;
                }
                return true;
            } catch( Exception e ) {
                error( e.getMessage() );
            }
            return false;
        }

