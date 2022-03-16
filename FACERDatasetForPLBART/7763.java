        @Override
        protected boolean cmdDialog( OutputStreamWriter os, BufferedReader is, BufferedReader es )  { 
            try {
                int num = list.length;
                double conv = 100./(double)num;
                String esc_dest = ExecEngine.prepFileName( dest_folder );
                for( int i = 0; i < num; i++ ) {
                    LsItem f = list[i];
                    if( f == null ) continue;
                    String file_name = f.getName();
                    String full_name = src_base_path + file_name;
                    String cmd = move ? " mv -f" : ( f.isDirectory() ? " cp -r" : " cp" );
                    String to_exec = cmd + " " + ExecEngine.prepFileName( full_name ) 
                                         + " " + esc_dest;
                    outCmd( true, to_exec, os );
                    if( procError( es ) ) return false;
                    
                    File    dst_file = new File( dest_folder, f.getName() );
                    String  dst_path = ExecEngine.prepFileName( dst_file.getAbsolutePath() ); 
                    Permissions perm = uid != null ? new Permissions( uid, uid, "-rw-rw----" ) :
                                                     new Permissions( f.getAttr() );
                    String chown_cmd = "chown " + perm.generateChownString().append(" ").append( dst_path ).toString();
                    outCmd( uid != null, chown_cmd, os );
                    String chmod_cmd = "chmod " + perm.generateChmodString().append(" ").append( dst_path ).toString();
                    outCmd( true, chmod_cmd, os );
                    
                    sendProgress( "'" + file_name + "'", (int)(i * conv) );
                    counter++;
                }
                return true;
            } catch( Exception e ) {
                error( e.getMessage() );
            }
            return false;
	    }

